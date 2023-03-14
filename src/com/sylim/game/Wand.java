package com.sylim.game;

public class Wand {
    private String name;
    private double power;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("에러메시지");
        }
        this.name = name;
    }
    
    public double getPower() {
        return power;
    }
    
    public void setPower(double power) {
        if (power < 0.5 || power > 100.0) {
            throw new IllegalArgumentException("에러메시지");
        }
        this.power = power;
    }
}
