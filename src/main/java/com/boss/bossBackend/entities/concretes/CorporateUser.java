package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.abstracts.CustomerAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "corporate_users")
@Getter
@Setter
public class CorporateUser extends CustomerAccount {

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
}
