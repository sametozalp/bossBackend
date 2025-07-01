package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleEnum name);

}
