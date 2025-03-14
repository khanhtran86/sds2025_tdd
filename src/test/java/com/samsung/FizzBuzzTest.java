package com.samsung;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void return_none_fizz_buzz_in_result()
    {
        int number = 2;
        List<String> expected = Arrays.asList("1", "2");

        //Action
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getFizzBuzz(number);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void return_fizz_in_result()
    {
        int number = 3;
        List<String> expected = Arrays.asList("1", "2", "Fizz");

        //Action
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getFizzBuzz(number);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void return_fizz_and_buzz_in_result()
    {
        int number = 5;
        List<String> expected = Arrays.asList("1", "2", "Fizz","4", "Buzz");

        //Action
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getFizzBuzz(number);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void return_fizzbuzz_in_result()
    {
        int number = 15;
        List<String> expected = Arrays.asList("1", "2", "Fizz","4", "Buzz","Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");

        //Action
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getFizzBuzz(number);

        //Assert
        assertEquals(expected, actual);

        //Hamcrest
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void return_empty_result_with_input_is_zero()
    {
        int number = 0;
        List<String> expected = new ArrayList<>();

        //Action
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getFizzBuzz(number);

        //Assert
        assertEquals(expected, actual);
    }
}
