package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String regexString(String inputString, String regexPattern) {
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(inputString);
        String result = org.apache.commons.lang3.StringUtils.EMPTY;
        while (m.find()) {
            result = m.group(1);
        }
        return result;
    }
}
