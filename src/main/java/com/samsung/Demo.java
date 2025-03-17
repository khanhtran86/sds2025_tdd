package com.samsung;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> files = Arrays.asList("AR_ENG_2024.pdf", "ER_ENG_2024.pdf");

        ReportFileProcessor reportFileProcessor;

        reportFileProcessor = new ReportFileProcessor();

        List<String> outPutFiles = reportFileProcessor.TranslateFileName(files);

        outPutFiles.forEach(System.out::println);
    }
}
