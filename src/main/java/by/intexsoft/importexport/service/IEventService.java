package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.Event;
import by.intexsoft.importexport.pojo.TypeEvent;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public interface IEventService<T extends Event> {
    void save(final List<T> list);
    List<T> getAll();
    TypeEvent getType();
    void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list);
    T buildEventByType(final CSVRecord record);

    default List<List<String>> convertEventToListStr(List<T> events){
        List<List<String>> listStr = newArrayList();
        events.forEach(event -> {
            List<String> strings = newArrayList();
            strings.add(event.getUuid().toString());
            strings.add(event.getDate().toString());
            listStr.add(strings);
        });
        return listStr;
    }
}
