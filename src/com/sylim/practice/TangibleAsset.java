package com.sylim.practice;

public abstract class TangibleAsset extends Asset implements Thing {
    private String color;
    private double weight;

    // Asset으로부터 상속
    public TangibleAsset(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }

    // Thing의 메소드
    // 추상 클래스이기 때문에 필수적으로 오버라이딩 해야하는 것은 아니나,
    // Book과 Computer에서 공통적으로 구현될 메소드이기 때문에 부모 클래스인 TangibleAsset에 하는 것이 적합하다고 봄
    public String getColor() {
        return color;
    }
    
    @Override
    public double getWeight() {
        return weight;
    };

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
}
