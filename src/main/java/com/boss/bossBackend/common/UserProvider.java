package com.boss.bossBackend.common;

import com.boss.bossBackend.entities.concretes.User;

public interface UserProvider<T> {
    T getSpecificUser(String id);
}
