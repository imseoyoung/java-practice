package com.sylim.practice.examUp10;

import static org.junit.Assert.*;
import org.junit.Test;

public class CounterTest {

    @Test
    public void test() {
        Counter counter = new Counter();
        counter.setCount(3);

        // 1회 실행
        counter.increment();
        assertEquals(4, counter.getCount());

        // 2회 실행
        counter.increment();
        counter.increment();
        assertEquals(6, counter.getCount());
    }
}
