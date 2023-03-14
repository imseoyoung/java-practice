package com.sylim.practice;

public class Main0310_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10 ; j ++) {
                // %nd -> n만큼 칸으로 오른쪽 정렬해서 출력
                System.out.printf("%d + %d = %2d \t", j, i, i*j);
            }
            System.out.println();
        }
    }
}
