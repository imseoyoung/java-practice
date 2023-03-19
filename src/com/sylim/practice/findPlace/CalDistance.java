package com.sylim.practice.findPlace;

import java.util.ArrayList;

public class CalDistance {
    
    public ArrayList<String> caldistance(Tree tree, WorkPlace wp) {
        double distance = Math.pow(tree.getX() - wp.getX(), 2) + Math.pow(tree.getY() - wp.getY(), 2);
        ArrayList<String> result = new ArrayList<String>();
        if (distance >= Math.pow(wp.getR(), 2)) {
            result.add("silent");
        } else {
            result.add("noisy");
        }
       return result;
    }
}
