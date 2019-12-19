package com.mum.se.unittest.mocktest;

import com.mum.se.unittest.mocktest.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReverserTestNull {
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

        when(arrayFlattenerService.flattenArray(null)).thenReturn(null);

        int[] finalArray = arrayReverser.reverseArray(null);
        assertArrayEquals(finalArray, null);
        verify(arrayFlattenerService).flattenArray(null);
    }
}