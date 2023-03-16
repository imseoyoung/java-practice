package com.sylim.practice.exam13;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        X x = new A();
//        Y y = new B();       
        ArrayList<Y> list = new ArrayList<Y>();
        list.add(new A());
        list.add(new B());
        
        for (Y obj : list) {
            obj.b();
        }      
    } 
}
