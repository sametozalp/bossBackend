package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.CorporateUser;

public class CorporateUserDetailResponse {

    private String id;
    private String companyName;
    private String contactPhone;
    private int foundationYear;
    private String taxNumber;
    private String taxOffice;
    private String taxPlate;
    private String tradeRegistryCertificate;

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

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getTaxPlate() {
        return taxPlate;
    }

    public void setTaxPlate(String taxPlate) {
        this.taxPlate = taxPlate;
    }

    public String getTradeRegistryCertificate() {
        return tradeRegistryCertificate;
    }

    public void setTradeRegistryCertificate(String tradeRegistryCertificate) {
        this.tradeRegistryCertificate = tradeRegistryCertificate;
    }
}
