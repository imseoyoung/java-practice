package com.sylim.game;

import java.util.Random;

public class Cleric {
    String name;
    int hp = 50;
    int mp = 10;
    int time;
    static final int MAX_HP = 50;
    static final int MAX_MP = 10;

    void selfAid() {
        mp -= 5;
        hp = MAX_HP;
    }

    int pray(int time) {
        // 1 -> 1~3, 2-> 2~4 3-> 3~5
        int heal = new Random().nextInt(3) + time;
        if (mp >= MAX_MP) {
            mp = MAX_MP;
        } else {
            mp += heal;
        }
        return heal;
    }
}
