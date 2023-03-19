package com.sylim.practice.findPlace;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        
        // 공사 현장      
        WorkPlace workplace = input.getWorkPlace();

        // 나무 그늘의 수
        ArrayList<Tree> trees = input.getTrees();

        // 계산
        ArrayList<String> totalResult = new ArrayList<String>();
        CalDistance cal = new CalDistance();
        for (Tree tree : trees) {
            ArrayList<String> result = cal.caldistance(tree, workplace);
            totalResult.addAll(result);
        }
        for (String r : totalResult) {
            System.out.println(r);
        }
    }
}
