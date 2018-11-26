package by.intexsoft.importexport.service;

import java.io.IOException;

public interface ImportEventService {
    void checkAndImport(String path) throws IOException;

}
