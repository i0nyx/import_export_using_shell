package by.intexsoft.importexport;

import by.intexsoft.importexport.config.ProjectConfig;
import by.intexsoft.importexport.service.ExportEventService;
import by.intexsoft.importexport.service.ImportEventService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class RunProject {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        ImportEventService importService = context.getBean(ImportEventService.class);
        ExportEventService exportEventService = context.getBean(ExportEventService.class);
//        importService.checkAndImport("d:/CALL_file.csv");
//        exportEventService.exportToCsv("call");

    }
}
