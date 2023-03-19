package com.sylim.practice.findPlace;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);
    
    public WorkPlace getWorkPlace() {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int R = scan.nextInt();
        return new WorkPlace(a, b, R);
    }

    public int getTreeNum() {
        return scan.nextInt();
    }

    public ArrayList<Tree> getTrees() {
        int N = scan.nextInt();
        ArrayList<Tree> trees = new ArrayList<Tree>();
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Tree tree = new Tree(x, y);
            trees.add(tree);
        }
        return trees;
    }
}
