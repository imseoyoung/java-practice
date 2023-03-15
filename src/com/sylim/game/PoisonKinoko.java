package com.sylim.game;

public class PoisonKinoko extends Kinoko {
    private int poison = 5;

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public PoisonKinoko(char suffix) {
        super(suffix);
    }

    @Override
    public void attack(Hero hero) {
        super.attack(hero);

        if (this.poison > 0) {
            System.out.println("추가로, 독 포자를 살포했다!");
            hero.setHP(hero.getHP() - hero.getHP() * 0.2);
            System.out.println(hero.getHP() + "포인트의 데미지");
            this.poison -= 1;
        }
    }
}
