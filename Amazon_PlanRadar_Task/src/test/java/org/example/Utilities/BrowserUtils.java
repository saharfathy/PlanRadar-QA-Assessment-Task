package org.example.Utilities;

public class BrowserUtils {

    public static int convertStringToInt(String text){
        String value = text.replaceAll("[^0-9]","");
        return  Integer.parseInt(value);
    }
}
