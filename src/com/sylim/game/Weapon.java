package com.sylim.game;

public class Weapon extends Item {
    public Weapon() {
        super("noname"); // super 생성자를 호출하지 않으면 에러 발
    }
    
    public Weapon(String name){
        super(name);
    }
}
