package com.boss.bossBackend.business.concretes;

public class SectorNotFoundException extends RuntimeException{

    public SectorNotFoundException(String message) {
        super(message);
    }
}
