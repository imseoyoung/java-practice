package com.sylim.practice.examUp6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String args[]) {
        try {
            // 객체 생성
            FileInputStream fis = new FileInputStream("data.txt"); // 기존 파일을 입력하면
            FileOutputStream fos = new FileOutputStream("data_copy.txt"); // 복사한 파일이 출력

            // 버퍼 생성
            byte[] buffer = new byte[1024];
            // 버퍼의 크기는 필요에 따라 변경할 수 있다
            
            // 버퍼링
            BufferedInputStream bins = new BufferedInputStream(fis);
            BufferedOutputStream bons = new BufferedOutputStream(fos);
            

            // 복사
            int bytesRead = bins.read(buffer);
            while (bytesRead != -1) {
                bons.write(buffer, 0, bytesRead);
                bytesRead = bins.read(buffer);
            }
            
            fis.close();
            fos.close();
            bins.close();

            // 복사한 파일 압축
            GZIPOutputStream gzipos = new GZIPOutputStream(new FileOutputStream("data_copy.zip"));
            FileInputStream fis2 = new FileInputStream("data_copy.txt");
            
            BufferedInputStream bins2 = new BufferedInputStream(fis2);
            
            int len;
            while ((len = bins2.read(buffer)) > 0) {
                gzipos.write(buffer, 0, len);
            }
            
            fis2.close();
            bins2.close();
            gzipos.finish();
            gzipos.close();
            System.out.println("압축 완료");
            
            // 압축 풀기
            GZIPInputStream gzipis = new GZIPInputStream(new FileInputStream("data_copy.zip"));
            FileOutputStream fos2 = new FileOutputStream("data_copy_zip.txt");
            
            BufferedOutputStream bons2 = new BufferedOutputStream(fos2);

            // 압축 해제
            while ((len = gzipis.read(buffer)) > 0) {
                bons2.write(buffer, 0, len);
            }
            fos2.close();
            bons2.close();
            gzipis.close();
            System.out.println("압축 해제 완료");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
