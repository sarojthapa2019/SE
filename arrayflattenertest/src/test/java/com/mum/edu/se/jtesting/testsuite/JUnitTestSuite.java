package com.mum.edu.se.jtesting.testsuite;

import com.mum.edu.se.jtesting.ArrayFlattenerTest;
import com.mum.edu.se.jtesting.ArrayFlattenerTestNull;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayFlattenerTest.class, ArrayFlattenerTestNull.class})
public class JUnitTestSuite {

}
