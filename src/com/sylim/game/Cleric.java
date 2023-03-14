package com.sylim.game;

import java.util.Random;

public class Cleric {
    String name;
    int hp = 50;
    int mp = 10;
    int time;
    static final int MAX_HP = 50;
    static final int MAX_MP = 10;

    // A
    Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    // B
    Cleric(String name, int hp) {
        this(name, hp, MAX_MP);
    }

    // C
    Cleric(String name) {
        this(name, MAX_HP, MAX_MP);
    }
    
    // D
//    Cleric() {
//        
//    }

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
