package com.ssg.ssg_be.notice.domain;
import com.ssg.config.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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
