package com.sylim.practice;

import java.util.Arrays;

public class Main0308_4 {
    public static void main(String[] args) {
        // 3개짜리 int형 배열 numbers 선언. 이 때 초기화는 각각 3, 4, 9
        int[] numbers = {3, 4, 9};
        // “1자리의 숫자를 입력 해 주세요"
        System.out.println("1자리의 숫자를 입력 해 주세요");
        int input = new java.util.Scanner(System.in).nextInt();
        // binarySearch : 이진 검색 알고리즘 사용
        // 지정된 배열에서 특정 값을 찾아 인덱스를 반환
        // 따라서, 인덱스 값을 반환한다면 중복된 값이 있다는 뜻이니 정답 출력
        // 중복된 값이 없을 경우, 음수를 반환한다.
        if (Arrays.binarySearch(numbers, input) >= 0) {
            System.out.println("정답!");
        }
    }
}
