package com.ssg.ssg_be.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class HappyLoungeDtoRes {
    private Long productId;
    private String name;
    private int price;
    private int sale;
    private Timestamp saleStartDate;
    private Timestamp saleEndDate;
    private String imgOriginName;
    private String imgSaveName;
    private String imgUrl;

    private List<HappyLoungeImgDto> happyLoungeImgDto;
}
