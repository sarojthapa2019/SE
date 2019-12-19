package com.edu.mum.se.testingdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticOpsTest {
    ArithmeticOps arithmeticOps;

    @Before
    public void setUp() throws Exception {
        arithmeticOps = new ArithmeticOps();
    }

    @After
    public void tearDown() throws Exception {
        arithmeticOps = null;
    }

    @Test
    public void add() {
        int a = 1;
        int b = 5;
        int e = 6;
        int ac = arithmeticOps.add(a, b);
        assertEquals(e, ac);
    }
}