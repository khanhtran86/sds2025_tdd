package com.samsung;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzTest {
    @Test(dataProvider = "fizzbuzzdata", groups = "sprint_1")
    public void return_fizz_buzz_result(int number, List<String> expectedResult) {
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        List<String> lstExpect = fizzBuzz.getFizzBuzz(number);

        //
        Assert.assertEquals(lstExpect, expectedResult);
    }

    @DataProvider(name = "fizzbuzzdata")
    public Object[][] fizzBuzzTestData(){
        return new Object[][]{
                {2, Arrays.asList("1", "2")},
                {3, Arrays.asList("1", "2", "fizz")},
                {4, Arrays.asList("1", "2", "fizz", "4")},
                {5, Arrays.asList("1", "2", "fizz", "4", "buzz")},
                {10, Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz","7","8","fizz", "buzz")},
                {15, Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz","7","8","fizz", "buzz","11","fizz","13","14","fizzbuzz")},
        };
    }

    @Test(description = "verify exception only")
    public void throw_exception_for_negative_number() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = new FizzBuzz();
            fizzBuzz.getFizzBuzz(-1);
        });
    }

    @Test(description = "verify exception and message")
    public void throw_exception_message_for_negative_number() {
        Exception exception = Assert.expectThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = new FizzBuzz();
            fizzBuzz.getFizzBuzz(-1);
        });

        Assert.assertEquals(exception.getMessage(), "Number must be positive");
    }
}
