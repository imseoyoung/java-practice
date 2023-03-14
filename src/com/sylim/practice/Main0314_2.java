package com.sylim.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main0314_2 {
    public static void main(String[] args) {       
       Person person1 = new Person();
       Person person2 = new Person();
       
       person1.name = "홍길동";
       person2.name = "한석봉";
       person1.age = 20;
       person2.age = 25;
       
       
       List<Person> personList = new ArrayList<>();
       personList.add(person1);
       personList.add(person2);

       Map<String, Integer> personMap = new HashMap<>();
       personMap.put(person1.name, person1.age);
       personMap.put(person2.name, person2.age);
       
       for (String key : personMap.keySet()) {
           int value = personMap.get(key);
           System.out.println(key + "의 나이는 " + value + "살");
       }
       
    }
}
