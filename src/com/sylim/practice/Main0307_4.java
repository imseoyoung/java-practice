package com.sylim.practice;

public class Main0307_4 {

    public static void main(String[] args) {
        // 화면에 "[숫자 맞추기 게임]"을 표시한다
        System.out.println("[숫자 맞추기 게임]");
        // 0~9 중 랜덤하게 수를 생성하고, 변수에 대입
        int ans = new java.util.Random().nextInt(10);
        // for문 (5회 반복)
        for (int i = 0; i < 5; i++) {
            System.out.println("0 ~ 9 사이의 숫자를 입력 하세요");
            int num = new java.util.Scanner(System.in).nextInt();
            // 조건문
            if (num == ans) {
                System.out.println("정답!");
                break;
            } else {
                System.out.println("다릅니다");
            }
        }
        // 반복 블록의 바깥에, "게임을 종료합니다"라고 표시한다
        System.out.println("게임을 종료합니다");
    }
}
