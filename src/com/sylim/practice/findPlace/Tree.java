package com.sylim.practice.findPlace;

import java.util.Objects;

public class Tree implements Thing {
    private int x; // x 좌표
    private int y; // y 좌표
    private int num; // 나무의 수

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    @Override
    public String toString() {
        return "Tree [x=" + x + ", y=" + y + ", num=" + num + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tree other = (Tree) obj;
        return num == other.num && x == other.x && y == other.y;
    }
}
