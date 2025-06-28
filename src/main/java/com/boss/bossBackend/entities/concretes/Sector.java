package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sectors")
public class Sector {

    @Id
    @Column(nullable = false, unique = true)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

}
