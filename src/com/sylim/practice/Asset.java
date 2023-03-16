package com.sylim.practice;

public abstract class Asset {
    private String name;
    private int price;
    
    public Asset(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public abstract String getName();
    
    public abstract int getPrice();
    
}

