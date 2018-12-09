package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Sms;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repository.SmsRepository;
import by.intexsoft.importexport.service.IEventService;
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

@Slf4j
@Service
@AllArgsConstructor
public class SmsService implements IEventService<Sms> {
    private final SmsRepository smsRepository;

    @Override
    public List<Sms> getAll() {
        return smsRepository.findAll();
    }

    @Override
    @Transactional
    public void save(final List<Sms> list) {
        smsRepository.saveAll(list);
        log.info("save sms {}", list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.SMS;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords> should not be null!"));
        save(list.stream().map(this::buildEventByType).collect(Collectors.toList()));
    }

    @Override
    public Sms buildEventByType(final CSVRecord record) {
        Optional.ofNullable(record).orElseThrow(() -> new IllegalArgumentException("should not be null"));
        return Sms.builder().uuid(UUID.fromString(record.get("uuid")))
                .date(LocalDate.parse(record.get("date")))
                .build();
    }
}
