package com.sylim.practice.examUp6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            // 객체 생성
            FileInputStream fis = new FileInputStream("data.txt"); // 기존 파일을 입력하면
            FileOutputStream fos = new FileOutputStream("data_copy.txt"); // 복사한 파일이 출력

            // 버퍼 생성
            byte[] buffer = new byte[1024];
            // 버퍼의 크기는 필요에 따라 변경할 수 있다

            // 복사
            int bytesRead = fis.read(buffer);
            while (bytesRead != -1) {
                fos.write(buffer, 0, bytesRead);
                bytesRead = fis.read(buffer);
            }
            
           fis.close();
           fos.close();
           
           System.out.println("복사 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
