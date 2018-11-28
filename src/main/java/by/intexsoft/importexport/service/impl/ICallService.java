package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Call;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.CallRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ICallService implements EventService<Call> {
    private final CallRepository callRepository;

    @Override
    public List<Call> getAll() {
        return callRepository.findAll();
    }

    @Override
    public void save(List<Call> list) {
        callRepository.saveAll(list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.Call;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords should not be null!"));
        save(list.stream().map(this::buildEventByType).collect(Collectors.toList()));
    }

    @Override
    public Call buildEventByType(CSVRecord record) {
        Optional.ofNullable(record).orElseThrow(() -> new IllegalArgumentException("should not be null!"));
        return Call.builder().uuid(UUID.fromString(record.get("uuid")))
                    .date(LocalDate.parse(record.get("date")))
                    .build();
    }
}
