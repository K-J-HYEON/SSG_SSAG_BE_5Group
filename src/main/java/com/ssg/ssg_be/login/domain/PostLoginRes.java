package com.ssg.ssg_be.login.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostLoginRes {
    private int id;
    private String jwt;
}
