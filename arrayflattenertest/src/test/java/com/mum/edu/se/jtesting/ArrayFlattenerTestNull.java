package com.mum.edu.se.jtesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTestNull {
    ArrayFlattener arrayFlattener;
    @Before
    public void setUp() throws Exception {
        arrayFlattener = new ArrayFlattener();
    }

    @After
    public void tearDown() throws Exception {
        arrayFlattener = null;
    }

    @Test
    public void flattenArray() {

        int[][] a = null;
        int[] expected = null;
        int[] actual = arrayFlattener.flattenArray(a);
        assertArrayEquals(expected, actual);
    }
}
