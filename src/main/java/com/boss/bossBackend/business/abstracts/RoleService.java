package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.enums.RoleEnum;

public interface RoleService {

    Role findByName(RoleEnum roleEnum);

}
