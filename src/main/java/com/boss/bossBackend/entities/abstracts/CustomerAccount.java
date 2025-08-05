package com.boss.bossBackend.entities.abstracts;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class CustomerAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalStatusEnum approvalStatusEnum = ApprovalStatusEnum.PENDING;

    @ManyToOne
    @JoinColumn(name = "associated_technopark_id", nullable = false)
    protected TechnoparkUser associatedTechnopark;
}
