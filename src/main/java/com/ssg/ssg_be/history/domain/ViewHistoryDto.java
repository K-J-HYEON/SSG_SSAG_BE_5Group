package com.ssg.ssg_be.history.domain;

import com.ssg.ssg_be.wish.domain.WishDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewHistoryDto {
    private Long viewHistoryId;
    private String name;
    private int price;
    private String productImg;
    private Long productId;
    private Long userUserId;
    private LocalDateTime createAt;
    private WishDto wishDto;
}
