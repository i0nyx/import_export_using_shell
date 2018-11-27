package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.TypeEvent;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public interface ConvertService {
    void chooseEventService(List<CSVRecord> lists, TypeEvent event);
}
