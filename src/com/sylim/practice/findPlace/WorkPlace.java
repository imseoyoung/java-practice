package com.sylim.practice.findPlace;

public class WorkPlace implements Thing {
    
    private int x;   // 공사장 x 좌표  
    private int y;   // 공사장 y 좌표     
    private int R;   // 공사장 소음 
    
    public WorkPlace() {
    }
    
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    public int getR() {
        return R;
    }
    public void setR(int r) {
        R = r;
    }
    
}
