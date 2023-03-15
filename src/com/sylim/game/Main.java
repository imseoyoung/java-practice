package com.sylim.game;

public class Main {

    public static void main(String[] args) {
        // 용사 생성
        Hero hero = new Hero();
        hero.setName("슈퍼맨");
        hero.setHP(100);
        System.out.println(hero.getName() + " : " + hero.getHP());
        
        PoisonKinoko poisonkinoko = new PoisonKinoko('A');
        poisonkinoko.attack(hero);
        System.out.println(poisonkinoko.getPoison());
    }
}
