package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "corporate_users")
public class CorporateUser extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "tax_plate")
    private String taxPlate;

    @Column(name = "trade_registry_certificate")
    private String tradeRegistryCertificate;

    @Column(name = "foundation_year")
    private Integer foundationYear;

    @Column(name = "tax_office")
    private String taxOffice;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "associated_technopark_id", nullable = false)
    private TechnoparkUser associatedTechnopark;


    public CorporateUser() {

    }

    public CorporateUser(CorporateUserCompleteProfileRequest request, User user, Sector sector, TechnoparkUser associatedTechnopark) {

        this.companyName = request.getCompanyName();
        this.taxNumber = request.getTaxNumber();
        this.contactPhone = request.getContactPhone();
        this.address = request.getAddress();
        //this.taxPlate = request.
        this.tradeRegistryCertificate = request.getTradeRegistryCertificate();
        this.foundationYear = request.getFoundationYear();
        this.taxOffice = request.getTaxOffice();

        this.user = user;
        this.sector = sector;
        this.associatedTechnopark = associatedTechnopark;
    }

    public TechnoparkUser getAssociatedTechnopark() {
        return associatedTechnopark;
    }

    public void setAssociatedTechnopark(TechnoparkUser associatedTechnopark) {
        this.associatedTechnopark = associatedTechnopark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
