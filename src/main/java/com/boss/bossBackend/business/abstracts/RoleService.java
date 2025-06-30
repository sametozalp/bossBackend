package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.entities.concretes.Role;

public interface RoleService {

    Role findById(int id);

}
