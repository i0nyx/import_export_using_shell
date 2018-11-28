package by.intexsoft.importexport.Util;

import java.io.File;

public final class StringUtil {
    public static String getStringType(String path){
        return new File(path).getName().split("_")[0];
    }
}
