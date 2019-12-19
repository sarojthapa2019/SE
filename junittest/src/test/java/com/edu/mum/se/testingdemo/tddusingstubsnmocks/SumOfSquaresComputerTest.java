package com.edu.mum.se.testingdemo.tddusingstubsnmocks;

import com.edu.mum.se.testingdemo.service.ISquareComputingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SumOfSquaresComputerTest {
    private SumOfSquaresComputer sumOfSquaresComputer;
//    private ISquareComputingService iSquareComputingService = new ISquareComputingService() {
//        @Override
//        public int[] computeSquares(int[] a_in) {
//            return new int[0];
//        }
//    }
    //mocking
    private ISquareComputingService iSquareComputingService = mock(ISquareComputingService.class);
    @Before
    public void setUp() throws Exception {
        this.sumOfSquaresComputer = new SumOfSquaresComputer(iSquareComputingService);
    }

    @After
    public void tearDown() throws Exception {
        this.sumOfSquaresComputer = null;
    }

    @Test
    public void computeSumOfSquares() {
//        int[] a_int = new int[]{1,2,3};
//        int expected = 14;
//        int actual = sumOfSquaresComputer.computeSumOfSquares(a_int);
//        assertEquals(expected,actual);

        when(iSquareComputingService.computeSquares(new int[]{1,2,3})).thenReturn(new int[]{1,4,9});
        int sumOfSquares = sumOfSquaresComputer.computeSumOfSquares(new int[]{1,2,3});
        assertThat(sumOfSquares, is(14));
        verify(iSquareComputingService).computeSquares(new int[]{1,2,3});
    }
}