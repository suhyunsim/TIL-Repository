package com.poogle.frogbook.templateCallbackPattern;

public class Soldier {
    void runContext(String weaponSound) {
        System.out.println("start");
        executeWeapon(weaponSound).runStrategy();
        System.out.println("finish");
    }

    private Strategy executeWeapon(final String weaponSound) {
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}
