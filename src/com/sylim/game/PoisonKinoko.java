package com.sylim.game;

public class PoisonKinoko extends Kinoko {
    private int poison;
    
    public PoisonKinoko(char suffix) {
        super(suffix);
        poison = 5;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }
 
    @Override // 어노테이션 주석
    public void attack(Hero hero) {
        super.attack(hero);
        double damage = hero.getHP() * 0.2;

        if (this.poison > 0) {
            System.out.println("추가로, 독 포자를 살포했다!");
            hero.setHP(hero.getHP() - damage);
            System.out.println(damage + "포인트의 데미지");
            this.poison --;
        }
    }
}
