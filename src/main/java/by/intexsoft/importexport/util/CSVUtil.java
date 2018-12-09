package by.intexsoft.importexport.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public final class CSVUtil {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char CUSTOM_QUOTE = ' ';

    public static void writeLine(Writer w, Object values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, Object values, char separators) throws IOException {
        writeLine(w, values, separators, CUSTOM_QUOTE);
    }

    private static String followCSVFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    public static void writeLine(Writer w, Object values, char separators, char customQuote) throws IOException {
        boolean first = true;

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : (List<String>) values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCSVFormat(value));
            } else {
                sb.append(customQuote).append(followCSVFormat(value)).append(customQuote);
            }
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
}