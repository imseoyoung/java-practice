package com.sylim.practice.exam14;

public class Main_account {
    public static void main(String[] args) {
        Account a = new Account("4649", 1592);
        System.out.println(a);       
        Account b = new Account(" 4649", 1592);
        
        if (a.equals(b)) {
           System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
    }
}
