package com.boss.bossBackend.common;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.User;

public class CorporateUserProvider implements UserProvider<CorporateUser> {

    private final CorporateUserService corporateUserService;

    public CorporateUserProvider(CorporateUserService corporateUserService) {
        this.corporateUserService = corporateUserService;
    }

    @Override
    public CorporateUser getSpecificUser(String id) {
        return corporateUserService.findById(id);
    }
}