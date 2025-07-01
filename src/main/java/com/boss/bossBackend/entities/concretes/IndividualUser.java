package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "individual_users")
@SQLRestriction(value = "deleted_at IS NULL")
public class IndividualUser extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;

    public IndividualUser() {

    }

    public IndividualUser(IndividualUserCompleteProfileRequest request, User user) {

        this.name = request.getName();
        this.surname = request.getSurname();
        this.phoneNumber = request.getPhoneNumber();
        this.socialSecurityNumber = request.getSocialSecurityNumber();
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
