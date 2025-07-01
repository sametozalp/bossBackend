package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.enums.RoleEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @Override
    public String getAuthority() {
        return this.name.name();
    }

    public Role() {

    }
}