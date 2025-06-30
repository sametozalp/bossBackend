package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.entities.concretes.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findByUserId(String userId);

    UserRole save(UserRole userRole);
}
