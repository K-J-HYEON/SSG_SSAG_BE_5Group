package com.ssg.ssg_be.nonmemberorder.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NonMemberOrder extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nonMemberOrderId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private NonMemberOrderList nonMemberOrderList;

    @Column(nullable = false)
    private Long productOptionId;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int totalPayment;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int orderState;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int shippingState;

    private int courierCompany;

    private String waybillNumber;
}
