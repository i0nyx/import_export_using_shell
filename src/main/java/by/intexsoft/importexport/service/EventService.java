package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.TypeEvent;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public interface EventService<T> {
    List<T> getAll();
    void save(List<T> list);
    TypeEvent getType();
    void convertOfCsvRecordToEventAndSave(List<CSVRecord> list);
    T buildEventByType(CSVRecord record);
}
