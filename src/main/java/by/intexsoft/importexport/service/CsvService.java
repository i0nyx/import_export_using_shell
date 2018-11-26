package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.TypeEvent;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface CsvService {
    List readCsvAndConvertToBean(Reader csvFile, TypeEvent type) throws IOException;
    void writeCsv(List<String> str);
}
