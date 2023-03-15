package com.sylim.game;

public class Main {

    public static void main(String[] args) {
        // 용사 생성
        Hero hero = new Hero();
        hero.setName("슈퍼맨");
        hero.setHP(100);
        System.out.println(hero.getName() + " : " + hero.getHP());

        Kinoko kinoko1 = new Kinoko();
        kinoko1.hp = 50;
        kinoko1.suffix = 'A';

        Kinoko kinoko2 = new Kinoko();
        kinoko2.hp = 50;
        kinoko2.suffix = 'B';

        // Cleric cleric = new Cleric();
        // cleric.selfAid();
        // System.out.println("현재 HP : " + cleric.hp + "\n현재 MP : " + cleric.mp);
        //
        // cleric.time = 2;
        // System.out.println(cleric.pray(cleric.time));

        // 생성자 동작 확인
        Cleric cleric = new Cleric("아서스", 35, 5);
        System.out.println(cleric.name);

        Cleric cleric2 = new Cleric("아서스", 40);
        System.out.println(cleric2.hp);

        Cleric cleric3 = new Cleric("아서스");
        System.out.println(cleric3.hp);

        // // 기본 생성자가 없으므로 오류 발생
        // Cleric cleric4 = new Cleric();
        // System.out.println(cleric3.hp);

        // 타당성 검사
        Wizard wizard = new Wizard();
        Wand wand = new Wand();

        // 에러 발생
        wand.setPower(100.1);
        wizard.setName("서영");
        wizard.setWand(null);
        wizard.setMP(-1);

        // 실행 결과 : 0
        wizard.setHP(-1);
        System.out.println(wizard.getHP());
    }
}
