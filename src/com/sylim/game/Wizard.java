package com.sylim.game;

public class Wizard {
    private String name;
    private int hp;
    private int mp;
    private Wand wand;
    
    public void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.power);
        hero.setHp(hero.getHP() + recovPoint);
    }
}