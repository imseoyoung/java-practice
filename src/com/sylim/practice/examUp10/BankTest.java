package com.sylim.practice.examUp10;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankTest {

    @Test
    public void constructor_test() {      
        Bank bank = new Bank();
        bank.setName("하나은행");
        assertEquals("하나은행", bank.getName());
        
        assertThrows(IllegalArgumentException.class, () -> bank.setName(""));
        assertThrows(IllegalArgumentException.class, () -> bank.setName("하나"));
        assertThrows(IllegalArgumentException.class, () -> bank.setName("하나은"));
    }

}
