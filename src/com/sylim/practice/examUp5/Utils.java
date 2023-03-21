package com.sylim.practice.examUp5;

public class Utils { 
    interface Func1 {
        public boolean call(int a);
    }
    
    interface Func2 {
        public String add(boolean x, String y);
    }
    
    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }
    
    public static String addNamePrefix(boolean male, String name) {
        if (male == true) {
            return "Mr." + name;
        }  
        return "Ms." + name;
    }
    
    public static void main(String[] args) {    
        Func1 func1 = Utils::isOdd;
        Func2 func2 = Utils::addNamePrefix;
            
        boolean result1 = func1.call(3);
        String result2 = func2.add(false, "임서영");
        System.out.println(result1);
        System.out.println(result2);
    }
}