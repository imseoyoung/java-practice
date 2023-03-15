package com.sylim.game;

public class Kinoko {
    private int hp = 50;
    private char suffix;
    
    public Kinoko(char suffix) {
        this.suffix = suffix;
    }
    
    public int getHP() {
        return hp;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
    
    public void attack(Hero hero) {
        System.out.println("키노코 " + this.suffix + " 의 공격");
        System.out.println("10의 데미지");
        hero.setHP(hero.getHP() - 10);
    }
    
//    void run() {
//        System.out.println("괴물 버섯 " + suffix + "는 도망쳤다");
//    }
    
    
}
