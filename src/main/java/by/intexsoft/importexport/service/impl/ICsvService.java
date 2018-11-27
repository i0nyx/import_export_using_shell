package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.CsvService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Slf4j
@Service
public class ICsvService implements CsvService {
    private final String[] header = {"uuid", "date"};

    public List<CSVRecord> readCsvAndConvertToListRecords(Reader csvFile, TypeEvent type) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader(header).withSkipHeaderRecord(true);
        CSVParser parser = new CSVParser(csvFile, format);
        return parser.getRecords();
    }

    public void writeCsv(List<String> str) {

    }
}