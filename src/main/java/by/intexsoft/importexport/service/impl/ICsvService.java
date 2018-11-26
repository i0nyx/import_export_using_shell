package by.intexsoft.importexport.service.impl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.CsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.List;

@Service
@Slf4j
public class ICsvService implements CsvService {
    public List readCsvAndConvertToBean(Reader csvFile, TypeEvent type) {
        CsvToBean csvToBean = new CsvToBean();
        CSVReader reader = new CSVReader(csvFile);
        return csvToBean.parse(setColumnMapping(TypeEvent.getEvent(type)), reader);
    }

    public void writeCsv(List<String> str) {

    }

    private ColumnPositionMappingStrategy setColumnMapping(Object obj) {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(obj.getClass());
        String[] columns = new String[] {"uuid", "date"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}