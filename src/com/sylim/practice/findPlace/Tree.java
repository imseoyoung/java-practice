package com.sylim.practice.findPlace;

public class Tree implements Thing {
    
    private int x;      // x 좌표
    private int y;      // y 좌표
    private int num;    // 나무의 수
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public void caldistance(WorkPlace wp) {
            double result = Math.pow(x - wp.getX(), 2) + Math.pow(y - wp.getY(), 2);            
            if (result >= Math.pow(wp.getR(), 2)) {
                System.out.println("silent");
            } else {
                System.out.println("noisy");
            }
        
    }
}
