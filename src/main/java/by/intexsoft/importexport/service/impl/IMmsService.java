package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Mms;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.MmsRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Service
@AllArgsConstructor
public class IMmsService implements EventService<Mms> {
    private final MmsRepository mmsRepository;

    @Override
    public List<Mms> getAll() {
        return mmsRepository.findAll();
    }

    @Override
    @Transactional
    public void save(final List<Mms> list) {
        mmsRepository.saveAll(list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.MMS;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords should not be null!"));
        save(list.stream().map(this::buildEventByType).collect(Collectors.toList()));
    }

    @Override
    public Mms buildEventByType(final CSVRecord record) {
        return null;
    }

    @Override
    public List<List<String>> convertToString() {
        List<Mms> calls = getAll();
        List<List<String>> listStr = newArrayList();
        for (Mms mms : calls) {
            List<String> strings = newArrayList();
            strings.add(mms.getUuid().toString());
            strings.add(mms.getDate().toString());
            listStr.add(strings);
        }
        return listStr;
    }
}
