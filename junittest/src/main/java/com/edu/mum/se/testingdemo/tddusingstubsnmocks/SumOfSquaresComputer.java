package com.edu.mum.se.testingdemo.tddusingstubsnmocks;

import com.edu.mum.se.testingdemo.service.ISquareComputingService;

public class SumOfSquaresComputer {
    private ISquareComputingService iSquareComputingService;

    public SumOfSquaresComputer(ISquareComputingService iSquareComputingService) {
        this.iSquareComputingService = iSquareComputingService;
    }

    public int computeSumOfSquares(int[] ints){
       // int[] sqr = {1,4,9};
        int[] sqr = iSquareComputingService.computeSquares(ints);
        int sum = 0;
        for(int i : sqr){
            sum += i;
        }
        return sum;
    }
}
