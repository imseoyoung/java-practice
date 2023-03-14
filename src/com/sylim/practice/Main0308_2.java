package com.sylim.practice;

public class Main0308_2 {
    public static void main(String[] args) {
        // moneyList 를 선언
        int[] moneyList = {121902, 8302, 55100};
        // 배열의 요소를 1개씩 for 문으로 꺼내서 화면에 표시
        for (int i = 0; i < moneyList.length; i++) {
            System.out.println(moneyList[i]);
        }
        // 같은 배열 요소를 foreach 문
        for (int money : moneyList) {
            System.out.println(money);
        }
    }
}
