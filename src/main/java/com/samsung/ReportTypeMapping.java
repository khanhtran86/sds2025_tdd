package com.samsung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportTypeMapping {
    private ReportSettingReader settingReader;
    public ReportTypeMapping(ReportSettingReader settingReader) {
        this.settingReader = settingReader;
    }

    public ReportTypeMapping() {
        this.settingReader = new ReportSettingReader();
    }

    public String From(String type) {
        //Read content from text
        String txtContent = settingReader.readTextFromFile("ReportSetting.xml");
        Pattern regex = Pattern.compile("<"+type+">(.*)<\\/"+type+">");
        Matcher matcher = regex.matcher(txtContent);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
