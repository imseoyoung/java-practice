package com.sylim.game;

public class Wizard {
    String name;
    int hp;
    
    void heal(Hero hero) {
        hero.hp += 10;
        System.out.println(hero.name + "의 HP를 10회복했다!");
    }
}
