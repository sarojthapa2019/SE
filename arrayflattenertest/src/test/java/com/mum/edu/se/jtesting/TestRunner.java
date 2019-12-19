package com.mum.edu.se.jtesting;


import com.mum.edu.se.jtesting.testsuite.JUnitTestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static  void main(String[] args){
        Result result = JUnitCore.runClasses(JUnitTestSuite.class);

        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
