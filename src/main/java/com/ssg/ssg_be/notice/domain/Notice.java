package com.ssg.ssg_be.notice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long noticeId;

    @Column(nullable = false)
    private Long title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

}
