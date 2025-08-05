package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.CorporateUser;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateUserDetailResponse {

    private String id;
    private String companyName;
    private String contactPhone;
    private int foundationYear;
    private String taxNumber;
    private String taxOffice;
    private String taxPlate;
    private String tradeRegistryCertificate;
    private LocalDateTime createdAt;

    public CorporateUserDetailResponse() {

    }

    public CorporateUserDetailResponse(CorporateUser corporateUser) {
        this.id = corporateUser.getId();
        this.companyName = corporateUser.getCompanyName();
        this.contactPhone = corporateUser.getContactPhone();
        this.foundationYear = corporateUser.getFoundationYear();
        this.taxNumber = corporateUser.getTaxNumber();
        this.taxOffice = corporateUser.getTaxOffice();
        this.taxPlate = corporateUser.getTaxPlate();
        this.tradeRegistryCertificate = corporateUser.getTradeRegistryCertificate();
        this.createdAt = corporateUser.getCreatedAt();

    }
}
