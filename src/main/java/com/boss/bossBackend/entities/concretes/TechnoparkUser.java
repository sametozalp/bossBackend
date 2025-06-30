package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "technopark_user")
public class TechnoparkUser extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    public  TechnoparkUser() {

    }

    public TechnoparkUser(TechnoparkRegisterRequest request, User user) {

        this.user = user;
        this.name = request.getTechnoparkName();
        this.location = request.getLocation();

    }

}
