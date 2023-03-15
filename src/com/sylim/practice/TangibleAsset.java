package com.sylim.practice;

public abstract class TangibleAsset {
    private String name;
    private int price;
    private String color;
    
    public TangibleAsset(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
    
    public abstract String getName();
    
    public abstract int getPrice();
    
    public abstract String getColor();
}