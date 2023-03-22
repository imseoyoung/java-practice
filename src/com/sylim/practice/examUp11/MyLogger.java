package com.sylim.practice.examUp11;

import java.io.*;

public final class MyLogger {
    private static MyLogger instance;
    private static BufferedWriter writer;
    
    private MyLogger() {} // new 금지
    
    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
            try {
                writer = new BufferedWriter(new FileWriter("dummylog.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    public void log(String content) {
        try {
            writer.write(content);
            writer.newLine();
            System.out.println("작성 완료");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("dummylog.txt");
        MyLogger logger1 = MyLogger.getInstance();// 로컬 인스턴스를 얻기
        logger1.log("first");
        MyLogger logger2 = MyLogger.getInstance();
        logger2.log("second");
     
    }      
}
