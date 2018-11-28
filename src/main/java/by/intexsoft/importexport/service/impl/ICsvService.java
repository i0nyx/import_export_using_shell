package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.Util.CSVUtil;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.ConvertService;
import by.intexsoft.importexport.service.CsvService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ICsvService implements CsvService {
    private ConvertService convertService;
    private final String[] header = {"uuid", "date"};

    public List<CSVRecord> readCsvAndConvertToListRecords(final Reader csvFile, final TypeEvent type) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader(header).withSkipHeaderRecord(true);
        CSVParser parser = new CSVParser(csvFile, format);
        return parser.getRecords();
    }

    public void writeCsv(FileWriter writer, final TypeEvent typeEvent) throws IOException {
        CSVUtil.writeLine(writer, Arrays.asList(header));
        List<List<String>> lists = convertService.chooseEventService(typeEvent).convertToString();
        for(List<String> list: lists){
            CSVUtil.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }
}