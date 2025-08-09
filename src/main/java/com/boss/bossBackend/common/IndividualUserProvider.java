package com.boss.bossBackend.common;

import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.User;

public class IndividualUserProvider implements UserProvider<IndividualUser> {

    private final IndividualUserService individualUserService;

    public IndividualUserProvider(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @Override
    public IndividualUser getSpecificUser(String id) {
        return individualUserService.findById(id);
    }
}