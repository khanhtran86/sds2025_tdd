package com.samsung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void should_return_number_in_text_of_native_number() {
        //Assumtion
        DocSo ds = new DocSo();
        int number = 6;
        String expected = "sau";

        //Action
        String result = ds.Doc2(number);

        //Assertion
        assertEquals(expected, result); //Testable - function phai assert dc
    }

    @Test
    public void should_return_message_with_large_than_9_number()
    {
        DocSo ds = new DocSo();
        int number = 20;
        String expected = "Chi doc dc so co gia tri tuyet doi <=9";

        //Action
        String result = ds.Doc2(number);

        //Assertion
        assertEquals(expected, result);
    }

    @Test
    public void should_return_number_in_text_with_negative_number()
    {
        DocSo docSo = new DocSo();
        int number = -6;
        String expected = "am sau";

        //Action
        String result = docSo.Doc2(number);

        //Assertion
        assertEquals(expected, result);
    }
}
