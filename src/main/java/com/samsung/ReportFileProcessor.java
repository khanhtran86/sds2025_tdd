package com.samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportFileProcessor {
    private ReportTypeMapping reportTypeMapping;
    public ReportFileProcessor(ReportTypeMapping reportTypeMapping)
    {
        this.reportTypeMapping = reportTypeMapping;
    }

    public ReportFileProcessor()
    {
        this.reportTypeMapping = new ReportTypeMapping();
    }

    public List<String> TranslateFileName(List<String> lstFiles) {
        List<String> lstResult = new ArrayList<String>();
        for (int i = 0; i < lstFiles.size(); i++) {
            String fileName = lstFiles.get(i);
            String regex = "([A-Z]+)_([A-Z]+)_([0-9]+)";
            Pattern fileNamePartPattern = Pattern.compile(regex);
            Matcher fileNamePartMatcher = fileNamePartPattern.matcher(fileName);
            String type;
            String year;
            if(fileNamePartMatcher.find())
            {
                type = fileNamePartMatcher.group(1);
                year = fileNamePartMatcher.group(3);
            }
            else
            {
                type = "";
                year = "";
            }
            String translatedFileName = fileName;
            if(!type.isEmpty()) {
                translatedFileName = this.reportTypeMapping.From(type);
            }

            lstResult.add(translatedFileName!=null?translatedFileName + " " + year:fileName);
        }
        return lstResult;
    }
}
