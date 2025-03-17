package com.samsung;

import org.mockito.internal.matchers.Any;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class ReportTypeMappingTest {
    @Test
    public void should_return_translate_type_from_setting()
    {
        //Arrange
        String type = "AR";
        String expected = "Annual Report";

        //Act
        ReportSettingReader fileReader = mock(ReportSettingReader.class);
        when(fileReader.readTextFromFile(any())).thenReturn("<setting><AR>Annual Report</AR></setting>");
        ReportTypeMapping mapper = new ReportTypeMapping(fileReader);

        String actual = mapper.From(type);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_null_if_these_is_no_has_setting()
    {
        //Arrange
        String type = "AR";
        String expected = null;

        ReportSettingReader fileReader = mock(ReportSettingReader.class);
        when(fileReader.readTextFromFile(any())).thenReturn("");
        ReportTypeMapping mapper = new ReportTypeMapping(fileReader);

        String actual = mapper.From(type);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_null_if_missing_setting()
    {
        //Arrange
        String type = "ER";
        String expected = null;

        ReportSettingReader fileReader = mock(ReportSettingReader.class);
        when(fileReader.readTextFromFile(any())).thenReturn("<setting><AR>Annual Report</AR></setting>");
        ReportTypeMapping mapper = new ReportTypeMapping(fileReader);

        String actual = mapper.From(type);

        assertEquals(expected, actual);
    }
}