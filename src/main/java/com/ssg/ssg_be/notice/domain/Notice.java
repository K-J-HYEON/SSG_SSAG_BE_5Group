package com.ssg.ssg_be.notice.domain;
import com.ssg.ssg_be.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Notice extends BaseTimeEntity {

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
