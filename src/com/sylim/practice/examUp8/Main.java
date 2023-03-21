package com.sylim.practice.examUp8;

import java.net.URL;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://alimipro.com/favicon.ico");

        InputStream is = url.openStream();
        
        FileOutputStream os = new FileOutputStream("icon.ico");
        
        // 그림 파일이니 4KB정도로 설정
        byte[] buffer = new byte[4096];
         
        // 파일의 처음부터 끝까지
        // InputStream에서 데이터를 읽고 FileOutputStream에 데이터 쓰기
        int bytesRead = -1;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
         }      
        System.out.println("저장 완료");
        
        is.close();
        os.close();       
    }
}
