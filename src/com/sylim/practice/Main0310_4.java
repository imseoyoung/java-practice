package com.sylim.practice;

import java.util.Scanner;
import java.util.Random;

public class Main0310_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("던질 횟수를 입력해주세요");
        long tries = scan.nextLong();
        int hits = 0;

        for (int i = 0; i < tries; i++) {
            // -1 ~ 1의 범위 랜덤 생성
            double x = new Random().nextDouble() * 2 - 1;
            double y = new Random().nextDouble() * 2 - 1;
            double distance = Math.sqrt(x * x + y * y);
            if (distance <= 1) {
                hits++;
            }
        }
        double piEstimate = 4 * (double) hits / tries;
        // double piEstimate = 4.0 * hits / tries; 이렇게 작성해도 됨
        System.out.println(piEstimate);
    }
}
