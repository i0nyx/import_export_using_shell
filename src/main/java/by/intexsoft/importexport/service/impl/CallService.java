package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Call;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repository.CallRepository;
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
public class CallService implements IEventService<Call> {
    private final CallRepository callRepository;

    @Override
    public List<Call> getAll() {
        return callRepository.findAll();
    }

    @Override
    @Transactional
    public void save(final List<Call> list) {
        callRepository.saveAll(list);
        log.info("save call {}", list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.CALL;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords> should not be null!"));
        List<Call> result = list.stream()
                .map(this::buildEventByType)
                .collect(Collectors.toList());
        save(result);
    }

    @Override
    public Call buildEventByType(final CSVRecord record) {
        Optional.ofNullable(record).orElseThrow(() -> new IllegalArgumentException("CSVRecord should not be null!"));
        return Call.builder().uuid(UUID.fromString(record.get("uuid")))
                    .date(LocalDate.parse(record.get("date")))
                    .build();
    }
}
