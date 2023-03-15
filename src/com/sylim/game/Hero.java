package com.sylim.game;

public class Hero {
    // field variable
    // global variable
    // member variable
    // property
    // default값이 모두 들어가 있음 (ex String - null, int - 0)
    private String name;
    private double hp;
    
    public void attack(Kinoko enemy) {
        System.out.println(this.name + "의 공격!");
        this.hp -= 5;
        System.out.println("5포인트의 데미지를 주었다!");
    }
    
    public void run() {
       System.out.println(this.name + "는 도망쳤다!");
    }
    
//    void sit(int sec) {}
//    
//    void slip() {}
//    
//    void sleep() {
//        hp = 100;
//        System.out.println(name + "는 잠을 자고 회복했다!");
//    }
    
    public double getHP() {
        return hp;
    }
    
    public void setHP(double hp) {
        this.hp = hp;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
