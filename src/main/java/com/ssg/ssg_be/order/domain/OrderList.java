package com.ssg.ssg_be.order.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderList extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderListId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private int refundType;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private String recipientPhone;

    @Column(nullable = false)
    private String addrName;

    @Column(nullable = false)
    private String streetAddr;

    @Column(nullable = false)
    private String zipCode;

    private String shippingMsg;

}
