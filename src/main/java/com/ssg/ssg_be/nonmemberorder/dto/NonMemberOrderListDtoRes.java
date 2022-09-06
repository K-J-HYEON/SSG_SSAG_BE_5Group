package com.ssg.ssg_be.nonmemberorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NonMemberOrderListDtoRes {
    private String name;
    private String phone;
    private String email;
    private String streetAddr;
    private String zipCode;
    private String shippingMsg;
    private LocalDateTime createAt;

    private List<NonMemberOrderDtoRes> orders;
}
