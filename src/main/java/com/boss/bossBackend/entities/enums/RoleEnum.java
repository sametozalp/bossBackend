package com.boss.bossBackend.entities.enums;

public enum RoleEnum {
    ADMIN(0),
    INVESTOR(1),
    ENTREPRENEUR(2);

    private final int value;

    RoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoleEnum fromValue(int value) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid RoleEnum value: " + value);
    }

}
