package com.samsung;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> getFizzBuzz(int number) {
        if(number<0)
        {
            throw new IllegalArgumentException("Number must be positive");
        }
        else {
            List<String> lstResult = new ArrayList<String>();
            for (int i = 1; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    lstResult.add("fizzbuzz");
                } else if (i % 3 == 0) {
                    lstResult.add("fizz");
                } else if (i % 5 == 0) {
                    lstResult.add("buzz");
                } else {
                    lstResult.add(String.valueOf(i));
                }

            }
            return lstResult;
        }
    }
}
