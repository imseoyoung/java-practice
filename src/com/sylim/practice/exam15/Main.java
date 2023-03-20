package com.sylim.practice.exam15;

public class Main {
    public static void main(String[] args) {
        try {
            String str = "Three";
                        // Integer.parseInt() 메소드는 문자열을 정수로 바꿔준다.
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("10진수 정수를 나타내는 문자여야 합니다. " + e.getMessage());
            e.printStackTrace();          
        }
    }
}