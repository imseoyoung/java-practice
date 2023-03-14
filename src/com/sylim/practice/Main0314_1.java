package com.sylim.practice;

import java.util.ArrayList;
import java.util.List;

public class Main0314_1 {
    public static void main(String[] args) {       
       Person person1 = new Person();
       Person person2 = new Person();
       
       person1.name = "홍길동";
       person2.name = "한석봉";
       
       
       List<Person> personList = new ArrayList<>();
       personList.add(person1);
       personList.add(person2);
       
       for (int i = 0; i < personList.size(); i++) {
           System.out.println(personList.get(i).name);
       }
    }
}
