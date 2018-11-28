package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Call;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.CallRepository;
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
public class ICallService implements EventService<Call> {
    private final CallRepository callRepository;

    @Override
    public List<Call> getAll() {
        return callRepository.findAll();
    }

    @Override
    @Transactional
    public void save(final List<Call> list) {
        callRepository.saveAll(list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.CALL;
    }

    @Override
    public void convertOfCsvRecordToEventAndSave(final List<CSVRecord> list) {
        Optional.ofNullable(list).orElseThrow(() -> new IllegalArgumentException("List<CSVRecords should not be null!"));
        save(list.stream().map(this::buildEventByType).collect(Collectors.toList()));
    }

    @Override
    public Call buildEventByType(final CSVRecord record) {
        Optional.ofNullable(record).orElseThrow(() -> new IllegalArgumentException("should not be null!"));
        return Call.builder().uuid(UUID.fromString(record.get("uuid")))
                    .date(LocalDate.parse(record.get("date")))
                    .build();
    }

    @Override
    public List<List<String>> convertToString() {
        List<Call> calls = getAll();
        List<List<String>> listStr = newArrayList();
        for(Call call : calls){
            List<String> strings = newArrayList();
            strings.add(call.getUuid().toString());
            strings.add(call.getDate().toString());
            listStr.add(strings);
        }
        return listStr;
    }
}
