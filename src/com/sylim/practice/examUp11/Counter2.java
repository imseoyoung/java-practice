package com.sylim.practice.examUp11;

public class Counter2 {
    private long count = 0;
    
    public synchronized void add(long i) {
        System.out.println("더하기");
        count += i;
    }
    
    public synchronized void mul(long i) {
        System.out.println("곱하기");
        count *= i;
    }
}
