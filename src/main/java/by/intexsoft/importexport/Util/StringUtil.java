package by.intexsoft.importexport.Util;

import by.intexsoft.importexport.pojo.TypeExtension;

import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class StringUtil {
    public static String getStringType(String path){
        return new File(path).getName().split("_")[0];
    }

    private static String getFileExtension(final String path){
        final int index = path.indexOf('.');
        return index == -1 ? null : path.substring(index + 1).toUpperCase();
    }

    public static void checkFileExtension(final String path){
        final String extension = getFileExtension(path);
        Optional.ofNullable(extension).orElseThrow(() -> new IllegalArgumentException("file not found"));
        assertEquals(extension, TypeExtension.valueOf(extension).toString());
    }
}