package com.boss.bossBackend.entities.abstracts;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CustomerAccount extends BaseEntity {

    @Column(name = "technopark_approved")
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
