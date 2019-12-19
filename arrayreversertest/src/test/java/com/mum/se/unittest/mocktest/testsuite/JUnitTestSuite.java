package com.mum.se.unittest.mocktest.testsuite;

import com.mum.se.unittest.mocktest.ArrayReverserTest;
import com.mum.se.unittest.mocktest.ArrayReverserTestNull;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayReverserTest.class, ArrayReverserTestNull.class})
public class JUnitTestSuite {

}
