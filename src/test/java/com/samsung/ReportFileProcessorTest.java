package com.samsung;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class ReportFileProcessorTest {
    @Test
    public void should_return_list_translated_file()
    {
        List<String> lstFiles = Arrays.asList("AR_ENG_2024.pdf", "ER_ENG_2023.pdf");
        List<String> lstExpected = Arrays.asList("Annual Report 2024", "Earning Release 2023");

        ReportTypeMapping rpnameMapper = mock(ReportTypeMapping.class);
        when(rpnameMapper.From("AR")).thenReturn("Annual Report");
        when(rpnameMapper.From("ER")).thenReturn("Earning Release");

        ReportFileProcessor rfp = new ReportFileProcessor(rpnameMapper);
        List<String> translatedFiles = rfp.TranslateFileName(lstFiles);

        assertEquals(lstExpected, translatedFiles);
    }

    @Test
    public void should_return_orignal_list_with_out_translate()
    {
        List<String> lstFiles = Arrays.asList("AR_ENG_2024.pdf", "ER_ENG_2023.pdf");
        ReportTypeMapping rpnameMapper = mock(ReportTypeMapping.class);
        when(rpnameMapper.From("AR")).thenReturn(null);
        when(rpnameMapper.From("ER")).thenReturn(null);

        ReportFileProcessor rfp = new ReportFileProcessor(rpnameMapper);
        List<String> translatedFiles = rfp.TranslateFileName(lstFiles);

        assertEquals(lstFiles, translatedFiles);
    }

    @Test
    public void should_return_list_with_some_translated_name_in_result_list()
    {
        List<String> lstFiles = Arrays.asList("AR_ENG_2024.pdf", "ER_ENG_2023.pdf");
        List<String> lstExpectedName = Arrays.asList("Annual Report 2024", "ER_ENG_2023.pdf");

        ReportTypeMapping rpnameMapper = mock(ReportTypeMapping.class);
        when(rpnameMapper.From("AR")).thenReturn("Annual Report");
        when(rpnameMapper.From("ER")).thenReturn(null);

        ReportFileProcessor rfp = new ReportFileProcessor(rpnameMapper);
        List<String> translatedFiles = rfp.TranslateFileName(lstFiles);

        assertEquals(lstExpectedName, translatedFiles);
    }
}
