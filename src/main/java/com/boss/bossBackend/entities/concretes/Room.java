package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    public Room() {
        
    }

    public Room(TechnoparkUser technoparkUser) {
        this.technoparkUser = technoparkUser;
    }
}
