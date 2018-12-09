package by.intexsoft.importexport;

import by.intexsoft.importexport.config.ProjectConfig;
import by.intexsoft.importexport.service.IImportEventService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class ProjectRunner {
    public static void main(String[] args) throws IOException {
//        Bootstrap.main(args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        IImportEventService IImportEventService = (IImportEventService) ctx.getBean("importEventService");
        String path = "D:/CALL_file.csv";
        IImportEventService.checkAndImport(path);
    }
}
