package com.boss.bossBackend.entities.abstracts;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class CustomerAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalStatusEnum approvalStatusEnum = ApprovalStatusEnum.PENDING;

    @ManyToOne
    @JoinColumn(name = "associated_technopark_id", nullable = false)
    protected TechnoparkUser associatedTechnopark;

    public TechnoparkUser getAssociatedTechnopark() {
        return associatedTechnopark;
    }

    public void setAssociatedTechnopark(TechnoparkUser associatedTechnopark) {
        this.associatedTechnopark = associatedTechnopark;
    }

    public ApprovalStatusEnum getApprovalStatusEnum() {
        return approvalStatusEnum;
    }

    public void setApprovalStatusEnum(ApprovalStatusEnum approvalStatusEnum) {
        this.approvalStatusEnum = approvalStatusEnum;
    }
}
