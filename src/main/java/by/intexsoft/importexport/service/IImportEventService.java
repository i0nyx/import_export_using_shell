package by.intexsoft.importexport.service;

import java.io.IOException;

public interface IImportEventService {
    void checkAndImport(final String path) throws IOException;
}