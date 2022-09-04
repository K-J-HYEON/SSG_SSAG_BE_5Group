package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.CategoryConn;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import com.ssg.ssg_be.product.domain.ProductTestWithNQ;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {

    Slice<CategoryProductDtoRes> findAllBy(Pageable pageable);

    @Query(value = "select * from\n" +
            "(select c.product_product_id as productId, r.reviewCount, r.reviewAvg " +
            "               from category_conn c left outer join (select *, count(*) as reviewCount, round(avg(score),1) as reviewAvg" +
            "                                                       from review group by product_id) r\n" +
            "on c.product_product_id = r.product_id) cr join\n" +
            "(select ps.product_id, name, price, sale, imgUrl, store_id, storeName, w.wish_id as wishId\n" +
            "from (select p.product_id, p.name, p.price, p.sale, p.img_url as imgUrl, p.store_id, s.name as storeName\n" +
            "        from product p join store s\n" +
            "        on p.store_id = s.store_id) ps left outer join (select * from wish where user_id = ?) w\n" +
            "on ps.product_id = w.product_id) psw\n" +
            "on cr.productId = psw.product_id", nativeQuery = true)
    Slice<ProductTestWithNQ> findAllWithReviewAndWish(Pageable pageable, Long userId);

    // 이슈 : 상품 목록을 조회할 때, 조회하는 데이터의 수가 늘수록 시간이 많이 소요된다.

    // 현재 방법 : 상품 정보를 먼저 불러오고 조회된 상품 개수만큼 반복문으로 해당 상품의 reviewTotal, wishId를 조회한다.

    // 해결방법 1 : JPQL을 사용하여 Join으로 한 번에 가져온다
    // 문제 1 : N+1 문제 발생 => fetch join으로 가져온다
    // 문제 2 : JPA 서브 쿼리의 한계 => from 절에서의 서브 쿼리를 지원하지 않아 해결 실패

    // 해결방법 2 : 네이티브 쿼리를 사용하여 상품 목록을 조회할 때, reviewTotal과 wishId를 조인하여 한 번에 가져온다.
    // 단점 : JPA를 사용하면서 네이티브 쿼리로 해결하면 DB 분리 시,해당 쿼리문을 쓸 수 없다. + JPA의 장점을 잃게 된다.

    // 해결방법 3 : API를 분리하여 상품 목록을 먼저 프론트로 반환하고, reviewTotal과 wishId는 프론트의 컴포넌트에서 따로 API를 호출하도록 한다.
    // 단점 : API 통신량이 많아질 수 있다.

    Slice<CategoryProductDtoRes> findByMediumCategoryId(Long mediumCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findBySmallCategorySmallCategoryId(Long smallCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByLargeCategoryId(Long largeCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByProductNameContaining(String searchWord, Pageable pageable);

}
