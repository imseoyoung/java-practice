package com.sylim.game;

public class Main {

    public static void main(String[] args) {
        // 용사 생성
        Hero hero = new Hero();
        hero.name = "슈퍼맨";
        hero.hp = 100;
        hero.sleep();
        System.out.println(hero.name + " : " + hero.hp);

        Kinoko kinoko1 = new Kinoko();
        kinoko1.hp = 50;
        kinoko1.suffix = 'A';

        Kinoko kinoko2 = new Kinoko();
        kinoko2.hp = 50;
        kinoko2.suffix = 'B';

        Cleric cleric = new Cleric();
        cleric.selfAid();
        System.out.println("현재 HP : " + cleric.hp + "\n현재 MP : " + cleric.mp);

        cleric.time = 2;
        System.out.println(cleric.pray(cleric.time));
    }
}
