package com.ssg.ssg_be.mainpage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class HappyLoungeImgDto {
    private Long thumbnailImgId;
    private String originName;
    private String saveName;
    private String imgUrl;
    private int priority;
}
