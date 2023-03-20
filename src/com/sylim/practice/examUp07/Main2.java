package com.sylim.practice.examUp07;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Department department = new Department("총무부", new Employee("홍길동", 41));
        
        // 저장
        FileOutputStream fos = new FileOutputStream("company.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(department);
        oos.flush();
        oos.close();
        
    }
}