package com.sylim.practice.exam12;

public class Computer extends TangibleAsset {
    private String makerName;

    public Computer(String name, int price, String color, String makerName) {
        super(name, price, color);
        this.makerName = makerName;
    }

    @Override    
    public String getName() {
        return getName();
    };
    @Override
    public int getPrice() {
        return getPrice();
    };
    @Override
    public String getColor() {
        return getColor();
    };

    public String getMakerName() {
        return getMakerName();
    };
}