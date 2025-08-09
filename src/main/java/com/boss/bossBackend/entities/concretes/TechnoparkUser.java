package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "technopark_users")
@Getter
@Setter
public class TechnoparkUser extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "technoparkUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    public  TechnoparkUser() {

    }

    public TechnoparkUser(TechnoparkRegisterRequest request, User user) {

        this.user = user;
        this.name = request.getTechnoparkName();
        this.location = request.getLocation();

    }
}
