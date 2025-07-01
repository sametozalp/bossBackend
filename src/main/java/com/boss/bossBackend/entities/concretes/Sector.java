package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sectors")
public class Sector extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    public Sector() {

    }

    public Sector(String name) {
        this.name = name;
    }

}
