package com.sylim.practice.examUp11;

public class CountUpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.print(i);
        }            
    }
    
    public static void main(String[] args) throws Exception {
        Thread thread1 = new CountUpThread();
        Thread thread2 = new CountUpThread();
        Thread thread3 = new CountUpThread();
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
