package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Mms;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.MmsRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Slf4j
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
        log.info("save mms {}", list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.MMS;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords> should not be null!"));
        save(list.stream().map(this::buildEventByType).collect(Collectors.toList()));
    }

    @Override
    public Mms buildEventByType(final CSVRecord record) {
        Optional.ofNullable(record).orElseThrow(() -> new IllegalArgumentException("should not be null"));
        return Mms.builder().uuid(UUID.fromString(record.get("uuid")))
                .date(LocalDate.parse(record.get("date")))
                .build();
    }

    @Override
    public List<List<String>> convertToListString() {
        List<Mms> listMms = getAll();
        List<List<String>> listStr = newArrayList();
        for (Mms mms : listMms) {
            List<String> strings = newArrayList();
            strings.add(mms.getUuid().toString());
            strings.add(mms.getDate().toString());
            listStr.add(strings);
        }
        return listStr;
    }
}
