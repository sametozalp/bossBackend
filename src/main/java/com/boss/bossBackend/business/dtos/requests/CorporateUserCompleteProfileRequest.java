package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CorporateUserCompleteProfileRequest {

    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Company name cannot be null")
    @NotBlank(message = "Company name cannot be blank")
    private String companyName;

    @NotNull(message = "Tax Plate name cannot be null")
    @NotBlank(message = "Tax Plate name cannot be blank")
    private String taxPlate;

    @NotNull(message = "Contact phone cannot be null")
    @NotBlank(message = "Contact phone cannot be blank")
    private String contactPhone;

    @NotNull(message = "Foundation year cannot be null")
    //@NotBlank(message = "Foundation year cannot be blank")
    private int foundationYear;

    @NotNull(message = "Tax number cannot be null")
    @NotBlank(message = "Tax number cannot be blank")
    private String taxNumber;

    @NotNull(message = "Tax office cannot be null")
    @NotBlank(message = "Tax office cannot be blank")
    private String taxOffice;

    @NotNull(message = "Trade registry certificate cannot be null")
    @NotBlank(message = "Trade registry certificate cannot be blank")
    private String tradeRegistryCertificate;

    @NotNull(message = "Sector ID cannot be null")
    //@NotBlank(message = "Sector ID cannot be blank")
    private int sectorId;

    @NotNull(message = "User ID cannot be null")
    @NotBlank(message = "User ID cannot be blank")
    private String userId;

    public String getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public String getTradeRegistryCertificate() {
        return tradeRegistryCertificate;
    }

    public int getSectorId() {
        return sectorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxPlate() {
        return taxPlate;
    }

    public void setTaxPlate(String taxPlate) {
        this.taxPlate = taxPlate;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public void setTradeRegistryCertificate(String tradeRegistryCertificate) {
        this.tradeRegistryCertificate = tradeRegistryCertificate;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
