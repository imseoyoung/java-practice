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
        if (name == null) {
            throw new IllegalArgumentException("에러메시지");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("에러메시지");
        }
        this.name = name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    public int getMP() {
        return mp;
    }

    public void setMP(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("에러메시지");
        }
        this.mp = mp;
    }
    
    public Wand getWand() {
        return wand;
    }
    
    public void setWand(Wand wand) {
        if (wand == null) {
            throw new IllegalArgumentException("에러메시지");
        }
        this.wand = wand;
    }

    public void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHP() + recovPoint);
    }
}
