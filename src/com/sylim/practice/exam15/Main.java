package com.sylim.practice.exam15;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("프로그램 시작");
            FileWriter fw = new FileWriter("data/data.txt"); // 잘못된 파일 경로
        } catch (IOException e) {
            System.out.println("에러 발생");
            e.printStackTrace();          
        }
    }
}