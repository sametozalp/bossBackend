package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.abstracts.CustomerAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "individual_users")
@SQLRestriction(value = "deleted_at IS NULL")
@Getter
@Setter
public class IndividualUser extends CustomerAccount {

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

    public IndividualUser(IndividualUserCompleteProfileRequest request, User user, TechnoparkUser associatedTechnopark) {

        this.name = request.getName();
        this.surname = request.getSurname();
        this.phoneNumber = request.getPhoneNumber();
        this.socialSecurityNumber = request.getSocialSecurityNumber();
        this.user = user;
        this.associatedTechnopark = associatedTechnopark;

    }
}
