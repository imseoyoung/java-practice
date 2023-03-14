package com.sylim.practice;

public class Main0310_3 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                // %nd -> n만큼 칸으로 오른쪽 정렬해서 출력
                System.out.printf("%d + %d = %2d \t", j, i, i * j);
            }
            System.out.println();
        }
    }
}

////배열로 풀기
//public class Main {
// // 배열의 행과 열 바꾸기
// public static void transpose(String time[][], String result[][]) {
//     for (int a = 0; a < time.length; a++) {
//         for (int b = 0; b < time[a].length; b++) {
//             result[b][a] = time[a][b];
//         }
//     }
// }
//
// public static void main(String[] args) {
//     String[][] time = new String[12][60];
//     for (int i = 1; i < 13; i++) {               // 시
//         for (int j = 0; j < 6; j++) {            // 분
//             for (int k = 0; k < 10; k++) {      
//                 time[i - 1][10 * j + k] = i + ":" + j + k;
//             }
//         }
//     }
//     String[][] result = new String[60][12];
//     transpose(time, result);
//
//     for (int x = 0; x < result.length; x++) {
//         for (int y = 0; y < result[x].length; y++) {
//             if (y != 11) {
//                 System.out.print(result[x][y] + " ");
//             } else {
//                 System.out.print(result[x][y]);
//             }
//         }
//         System.out.println();
//     }
// }
//}