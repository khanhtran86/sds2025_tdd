package com.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StandartText {
    public String Makestardardtext(String text)
    {
        text = removeBraketContent(text);
        text = removeEndOfSentence(text);
        text = getFirst20Character(text);
        return text;
    }
    
    private String removeBraketContent(String text)
    {
        return text.replaceAll("\\(.*\\)", "").trim();
    }

    private String removeEndOfSentence(String text)
    {
        List<String> lstTextToRemove = Arrays.asList("test","tst", "st", "app", "application");
        boolean replaced = false;
        for (String s : lstTextToRemove)
        {
            if(!text.endsWith(s))
                continue;
            else
            {
                text = text.substring(0, text.length() - s.length()).trim();
                replaced = true;
                break;
            }
        }
        if(replaced)
            return removeEndOfSentence(text);
        else
            return text;
    }

    private String getFirst20Character(String text)
    {
        if(text.length()<20)
            return text;
        return text.substring(0, 20).trim();
    }
}
