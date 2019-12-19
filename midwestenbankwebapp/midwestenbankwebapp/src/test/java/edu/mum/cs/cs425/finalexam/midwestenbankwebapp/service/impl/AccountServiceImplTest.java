package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

    @Autowired
    private IAccountService accountService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComputeNetLiquidity() {
        Double actual = accountService.computeNetLiquidity();
        Double expected = 485596.21;
        assertEquals(expected, actual, 0.10);
    }
}