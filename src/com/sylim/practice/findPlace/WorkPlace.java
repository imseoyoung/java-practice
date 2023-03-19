package com.sylim.practice.findPlace;

import java.util.Objects;

public class WorkPlace implements Thing {
    
    private int x;   // 공사장 x 좌표  
    private int y;   // 공사장 y 좌표     
    private int R;   // 공사장 소음 
    
    
    public WorkPlace(int x, int y, int r) {
        super();
        this.x = x;
        this.y = y;
        R = r;
    }
    
    public int getR() {
        return R;
    }
    public void setR(int r) {
        R = r;
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
    @Override
    public String toString() {
        return "WorkPlace [x=" + x + ", y=" + y + ", R=" + R + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(R, x, y);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WorkPlace other = (WorkPlace) obj;
        return R == other.R && x == other.x && y == other.y;
    }
}
