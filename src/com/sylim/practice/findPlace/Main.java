package com.sylim.practice.findPlace;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 공사 현장
        int a = scan.nextInt();
        int b = scan.nextInt();
        int R = scan.nextInt();

        WorkPlace wp = new WorkPlace();
        wp.setX(a);
        wp.setY(b);
        wp.setR(R);

        // 나무 그늘의 수
        int N = scan.nextInt();

        Tree tree = new Tree();
        tree.setNum(N);

        // 계산
        ArrayList<String> totalResult = new ArrayList<String>();
        CalDistance cal = new CalDistance();
        for (int i = 0; i < N; i++) {
            int x_i = scan.nextInt();
            int y_i = scan.nextInt();
            tree.setX(x_i);
            tree.setY(y_i);
            ArrayList<String> result = cal.caldistance(tree, wp);
            totalResult.addAll(result);
        }
        for (String r : totalResult) {
            System.out.println(r);
        }
    }
}
