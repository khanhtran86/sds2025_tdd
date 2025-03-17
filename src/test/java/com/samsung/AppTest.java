package com.samsung;

import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /*
    @BeforeTest, @AfterTest
    @BeforeMethod, @AfterMethod
    @Test
     */

    @BeforeTest
    public void before_test()
    {
        System.out.println("before test");
    }

    @AfterTest
    public void after_test()
    {
        System.out.println("after test");
    }

    @BeforeMethod
    public void before_method()
    {
        System.out.println("before method");
    }

    @AfterMethod
    public void after_method()
    {
        System.out.println("after method");
    }

    @Test(priority = 2, groups = "sprint_2", description = "Day la test case demo so 1")
    public void TestNG_method()
    {
        System.out.println("TestNG method");
    }

    @Test(priority = 1, groups = "sprint_2")
    public void TestNG_method_2()
    {
        assertThat(1, equalTo(1));
    }
}
