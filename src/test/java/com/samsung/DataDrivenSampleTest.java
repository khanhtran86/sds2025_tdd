package com.samsung;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenSampleTest {
    @Test(dataProvider = "test_data_numbers", groups = "sprint_2")
    public void return_result_of_add_calculator(int firstNumber, int secondNumber, int expectedResult)
    {
        DataDrivenSample dds = new DataDrivenSample();

        //Act
        int actualResult =dds.AddNumber(firstNumber, secondNumber);

        //Assert
        assertThat(actualResult, equalTo(expectedResult));
    }

    @DataProvider(name = "test_data_numbers")
    public Object[][] generateTestData()
    {
        return new Object[][] {
                {1,2,3},
                {-1,-2,-3},
                {0,2,2}
        };
    }
}
