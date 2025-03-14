package com.samsung;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StandardTextTest {
    @Test
    public void should_remove_content_in_single_bracket() {
        //Assumsion
        String text = "Hello world (we are samsung developer)";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_remove_content_in_multiple_braket() {
        //Assumsion
        String text = "Hello world (we are (samsung) developer)";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_remove_content_in_multiple_open_braket() {
        //Assumsion
        String text = "Hello world (we are (samsung (developer)";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_remove_cotent_in_open_bracket_and_multiple_open_braket() {
        //Assumsion
        String text = "Hello world (we are samsung) developer))";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_return_text_with_out_braket_and_removable_end_of_text() {
        //Assumsion
        String text = "Hello world";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_remove_single_removable_at_end_of_text()
    {
        //Assumsion
        String text = "Hello world app";
        String expected = "Hello world";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void should_remove_multiple_removable_at_end_of_text()
    {
        //Assumsion
        String text = "test Hello test worldtestappapplication";
        String expected = "test Hello test worl";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void get_all_text_with_20_characters() {
        String text = "Hello world we are samsung developer";

        String expected = "Hello world we are s";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void get_all_text_with_20_characters_after_standard() {
        String text = "Hello world we are (samsung (developer)). We are developing application";
        String expected = "Hello world we are .";

        //Action
        StandartText stadarter = new StandartText();
        String actual = stadarter.Makestardardtext(text);

        //Assertion
        assertThat(actual, equalTo(expected));
    }
}
