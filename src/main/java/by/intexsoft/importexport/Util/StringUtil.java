package by.intexsoft.importexport.Util;

import java.io.File;

public class StringUtil {
    public static String getStringType(String path){
        String name = new File(path).getName().split("_")[0];
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
