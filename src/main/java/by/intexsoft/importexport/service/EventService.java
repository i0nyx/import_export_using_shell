package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.TypeEvent;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public interface EventService<T> {
    List<T> getAll();
    void save(final List<T> list);
    TypeEvent getType();
    void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list);
    T buildEventByType(final CSVRecord record);
    List<List<String>> convertToString();
}
