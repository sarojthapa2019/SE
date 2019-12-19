package com.mum.se.unittest.mocktest;

import com.mum.se.unittest.mocktest.service.ArrayFlattenerService;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;


public class ArrayReverser {
    ArrayFlattenerService arrayFlattenerService;

    public ArrayReverser(ArrayFlattenerService arrayFlattenerService){
        this.arrayFlattenerService  =  arrayFlattenerService;
    }
    public int[] reverseArray(int[][] arr) {
        // int[] flattenArray = new int[]{1,3,0,4,5,9};

            int[] flattenedArray = arrayFlattenerService.flattenArray(arr);
            if(flattenedArray !=null) {
                for (int i = 0; i < flattenedArray.length / 2; i++) {
                    int j = flattenedArray[i];
                    flattenedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
                    flattenedArray[flattenedArray.length - 1 - i] = j;
                }
                return flattenedArray;
            }else{
                return null;
            }

    }
}
