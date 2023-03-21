package com.sylim.practice.examUp5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    interface Func1 {
        public boolean call(int a);
    }

    interface Func2 {
        public String add(boolean x, String y);
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static String addNamePrefix(boolean male, String name) {
        if (male == true) {
            return "Mr." + name;
        }
        return "Ms." + name;
    }

    public static void main(String[] args) {
        Func1 func1 = n -> n % 2 == 1;
        Func2 func2 = (male, name) -> {
            if (male == true) {
                return "Mr." + name;
            }
            return "Ms." + name;
        };

        boolean result1 = func1.call(3);
        String result2 = func2.add(false, "임서영");
        System.out.println(result1);
        System.out.println(result2);
        
        // 스트림 사용해보기
        List<String> names = new ArrayList<>(Arrays.asList("John", "Emily", "Mike", "Sarah"));
        
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("M"))
                .map(name -> func2.add(true, name))
                .collect(Collectors.toList());
        
        System.out.println(filteredNames);      
    }
}