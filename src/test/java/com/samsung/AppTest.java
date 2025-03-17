package com.samsung;

import Models.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void should_return_list_with_matched_keyword_in_firstname_and_lastname() throws IOException {
        String keyword = "khanh";
        List<Person> lstPerson = Arrays.asList(
                Person.builder().id(3).first_name("nguyen").last_name("khanh").email("khanh.nguyen@gmail.com").build(),
                Person.builder().id(1).first_name("tran").last_name("khanh").email("khanh.tx").build(),
                Person.builder().id(2).first_name("nguyen").last_name("hung").email("hungnguyen@gmail.com").build()
        );

        List<Person> expectedResult = Arrays.asList(
                Person.builder().id(1).first_name("tran").last_name("khanh").email("khanh.tx").build(),
                Person.builder().id(3).first_name("nguyen").last_name("khanh").email("khanh.nguyen@gmail.com").build()
        );
        PersonReader pReader = mock(PersonReader.class);
        when(pReader.fromJson(any())).thenReturn(lstPerson);
        App app = new App(pReader);

        //Act
        List<Person> persons = app.search(keyword);

        Assert.assertTrue(persons.size()>0);
        Assert.assertTrue(expectedResult.containsAll(persons));

    }

    @Test
    public void should_return_matched_list_with_email() throws IOException {
        String keyword = "khanh";
        List<Person> lstPerson = Arrays.asList(
                Person.builder().id(3).first_name("nguyen").last_name("hung").email("khanh.nguyen@gmail.com").build(),
                Person.builder().id(1).first_name("tran").last_name("trung").email("khanh.tx").build(),
                Person.builder().id(2).first_name("hoang").last_name("hung").email("hungnguyen@gmail.com").build()
        );

        List<Person> expectedResult = Arrays.asList(
                Person.builder().id(3).first_name("nguyen").last_name("hung").email("khanh.nguyen@gmail.com").build(),
                Person.builder().id(1).first_name("tran").last_name("trung").email("khanh.tx").build()
        );

        PersonReader pReader = mock(PersonReader.class);
        when(pReader.fromJson(any())).thenReturn(lstPerson);
        App app = new App(pReader);

        List<Person> persons = app.search(keyword);

        Assert.assertTrue(persons.size()>0);
        Assert.assertTrue(expectedResult.containsAll(persons));
    }

    //@Test(expectedExceptions=NullPointerException.class)
    @Test
    public void return_no_result_with_no_matched_return() throws IOException {
        String keyword = "huong";
        List<Person> lstPerson = Arrays.asList(
                Person.builder().id(3).first_name("nguyen").last_name("hung").email("khanh.nguyen@gmail.com").build(),
                Person.builder().id(1).first_name("tran").last_name("trung").email("khanh.tx").build(),
                Person.builder().id(2).first_name("hoang").last_name("hung").email("hungnguyen@gmail.com").build()
        );

        PersonReader pReader = mock(PersonReader.class);
        when(pReader.fromJson(any())).thenReturn(lstPerson);
        App app = new App(pReader);
        //app.search(keyword);
        Assert.assertThrows(NullPointerException.class, () -> app.search(keyword));
    }

    @Test
    public void should_return_empty_list_if_have_exception_in_reading_file() throws IOException {
        String keyword="khanh";
        PersonReader pReader = mock(PersonReader.class);
        when(pReader.fromJson(any())).thenThrow(new IOException("File not found"));

        App app = new App(pReader);
        List<Person> lstResult = app.search(keyword);
        Assert.assertTrue(lstResult.size()==0);
    }
}
