package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.CategoryConn;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import com.ssg.ssg_be.product.domain.ProductWithWishDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {

    @Query(value = "select * from\n" +
            "    (select c.product_product_id as productId, r.reviewCount, r.reviewAvg\n" +
            "    from category_conn c left outer join (select *, count(*) as reviewCount, round(avg(score),1) as reviewAvg\n" +
            "                                          from review group by product_id) r\n" +
            "    on c.product_product_id = r.product_id) cr join\n" +
            "    (select ps.product_id, name, price, sale, sale_start_date as saleStartDate, sale_end_date as saleEndDate,\n" +
            "            img_origin_name as imgOriginName, img_save_name as imgSaveName, img_url," +
            "            store_id as storeId, storeName, w.wish_id as wishId\n" +
            "    from (select p.product_id, p.name, p.price, p.sale, p.sale_start_date, p.sale_end_date,\n" +
            "                 p.img_origin_name, p.img_save_name, p.img_url, p.store_id, s.name as storeName\n" +
            "          from product p join store s\n" +
            "          on p.store_id = s.store_id) ps left outer join (select * from wish where user_id = ?) w\n" +
            "    on ps.product_id = w.product_id) psw\n" +
            "on cr.productId = psw.product_id", nativeQuery = true)
    Slice<ProductWithWishDto> findAllWithReviewAndWish(Pageable pageable, Long userId);

    Slice<CategoryProductDtoRes> findByMediumCategoryId(Long mediumCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findBySmallCategorySmallCategoryId(Long smallCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByLargeCategoryId(Long largeCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByProductNameContaining(String searchWord, Pageable pageable);

}
