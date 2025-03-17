package com.samsung;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class ReportSettingReader {
    public String readTextFromFile(String filename)
    {
        StringBuilder text = new StringBuilder();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL fileName = classLoader.getResource(filename);
            if(fileName==null) return "";

            File file = new File(fileName.getFile());

            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                text.append(line);
            }
        } catch (IOException e) {
            return "";
        }
        return text.toString();
    }
}
