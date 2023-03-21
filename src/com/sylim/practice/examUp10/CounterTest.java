package com.sylim.practice.examUp10;

import static org.junit.Assert.*;
import org.junit.Test;

public class CounterTest {

    @Test
    public void test() {
        UpCounter counter = new UpCounter();
        counter.setCount(3);

        // 1회 실행
        counter.count();
        assertEquals(4, counter.getCount());

        // 2회 실행
        counter.count();
        counter.count();
        assertEquals(6, counter.getCount());
    }
}
