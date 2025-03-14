package com.samsung;

public class DocSo {

    public String Doc2(int number)
    {
        String result = number<0? "am ": "";
        number = Math.abs(number);

        if(number > 9)
            return "Chi doc dc so co gia tri tuyet doi <=9";
        else {
            String[] str = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};
            result += str[number];
        }
        return result;
    }
}
