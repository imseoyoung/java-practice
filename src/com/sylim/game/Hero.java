package com.sylim.game;

public class Hero {
    // field variable
    // global variable
    // member variable
    // property
    // default값이 모두 들어가 있음 (ex String - null, int - 0)
    String name;
    int hp;
    
    void attack() {}
    void run() {}
    void sit(int sec) {}
    void slip() {}
    void sleep() {
        hp = 100;
        System.out.println(name + "는 잠을 자고 회복했다!");
    }
    
    public int getHP() {
        return hp;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
    
}
