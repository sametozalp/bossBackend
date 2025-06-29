package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {



}
