package com.sylim.game;

public class Wizard {
    private String name;
    private int hp;
    private int mp;
    private Wand wand;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHP() {
        return hp;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
    
    public int getMP() {
        return mp;
    }
    
    public void setMP(int mp) {
        this.mp = mp;
    }
    
    public void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHP() + recovPoint);
    }
}