package com.sylim.practice.examUp10;

import static org.junit.Assert.*;
import org.junit.Test;

public class CounterTest {

    @Test
    public void test() {
        Counter counter = new Counter();
        counter.setCount(3);

        // 1회 실행
        counter.increase();
        assertEquals(4, counter.getCount());

        // 2회 실행
        counter.increase();
        counter.increase();
        assertEquals(6, counter.getCount());
    }
}
