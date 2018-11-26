package by.intexsoft.importexport;

import by.intexsoft.importexport.Util.StringUtil;
import by.intexsoft.importexport.pojo.TypeEvent;

import java.io.IOException;

public class RunProject {

    public static void main(String[] args) throws IOException {
        String eventTypeStr = StringUtil.getStringType("d:/CALL_file.csv");
        Object obj = TypeEvent.getEvent(TypeEvent.valueOf(eventTypeStr));
        System.out.println(obj.getClass());
    }
}
