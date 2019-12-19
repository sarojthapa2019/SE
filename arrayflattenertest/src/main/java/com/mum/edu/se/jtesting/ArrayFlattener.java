package com.mum.edu.se.jtesting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayFlattener {

    public int[] flattenArray(int[][] arr) {
        if (arr != null) {
            return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        } else {
            return null;
        }

    }
}
