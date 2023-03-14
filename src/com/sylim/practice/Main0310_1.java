package com.sylim.practice;

public class Main0310_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("3초간 기다림!");
        Thread.sleep(3000);
        System.out.println("끝");
    }
}

//throws Exception을 안 할 경우 예외처리를 따로 해줘야 한다.        
//try {
//  Thread.sleep(3000);
//  System.out.println("끝");
//} catch(InterruptedException e) {
//  e.printStackTrace();
//}