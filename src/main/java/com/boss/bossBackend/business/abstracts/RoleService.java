package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.enums.RoleEnum;

public interface RoleService {

    Role findByName(RoleEnum roleEnum);

    SuccessResult saveToDb(RoleEnum roleEnum);

}
