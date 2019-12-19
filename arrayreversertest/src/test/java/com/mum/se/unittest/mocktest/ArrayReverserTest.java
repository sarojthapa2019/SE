package com.mum.se.unittest.mocktest;

import com.mum.se.unittest.mocktest.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReverserTest {
        private ArrayReverser arrayReverser;
        //mocking
        private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
    @Before
    public void setUp() throws Exception {
        this.arrayReverser = new ArrayReverser(arrayFlattenerService);
    }

    @After
    public void tearDown() throws Exception {
        this.arrayReverser = null;
    }


    @Test
    public void reverseArray() {
        int[][] input = new int[][]{{1,3},{0},{4,5,9}};
        when(arrayFlattenerService.flattenArray(input)).thenReturn(new int[]{1,3,0,4,5,9});
        int[] finalArray = arrayReverser.reverseArray(input);
        assertArrayEquals(finalArray, new int[]{9,5,4,0,3,1});
        verify(arrayFlattenerService).flattenArray(input);
    }
}