package com.mum.se.unittest.mocktest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        int[] flattenArray = new int[]{1,3,0,4,5,9};
         Collections.reverse(Arrays.asList(flattenArray));
        System.out.println( Arrays.asList(flattenArray) );
    }
}
