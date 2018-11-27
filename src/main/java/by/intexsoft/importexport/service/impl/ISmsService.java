package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Sms;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.SmsRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ISmsService implements EventService<Sms> {
    private final SmsRepository smsRepository;

    @Override
    public List<Sms> getAll() {
        return smsRepository.findAll();
    }

    @Override
    public void save(List list) {
        System.out.println("Sms " + list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.Sms;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(List<CSVRecord> list) {

    }

    @Override
    public Sms buildEventByType(CSVRecord record) {
        return null;
    }
}
