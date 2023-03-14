package com.sylim.practice;

public class Main0307_1 {
    public static void main(String[] args) {
        // 변수 선언
        int weight = 60;
        int age1 = 20;
        int age2 = 30;
        int age = 15;
        String name = "스마트";
             
        // 변수 weight의 값이 60과 같다
        if (weight == 60) {
            System.out.println("같습니다");
        }
        // 변수 age1과 age2의 합계를 2배 한 것이 60을 넘는다
        if ((age1 + age2) * 2 > 60) {
            System.out.println("넘습니다");
        }
        // 변수 age가 홀수다
        if (age % 2 != 0) {
            System.out.println("홀수입니다");
        }
        // 변수 name에 저장된 문자열이 "스마트"와 같다
        if (name.equals("스마트")) {
            System.out.println("같습니다");
        }
    }
}
