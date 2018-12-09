package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.util.StringUtil;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.IConvertService;
import by.intexsoft.importexport.service.ICsvService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class ImportEventService implements by.intexsoft.importexport.service.IImportEventService {
    private final ICsvService ICsvService;
    private final IConvertService IConvertService;

    @Override
    public void checkAndImport(final String path) throws IOException {
        StringUtil.checkFileExtension(path);
        TypeEvent type = TypeEvent.valueOf(StringUtil.getStringType(path).toUpperCase());
        List<CSVRecord> csvRecords = ICsvService.readCsvAndConvertToListRecords(new FileReader(path), type);
        IConvertService.chooseEventService(type).convertOfCsvRecordToEventAndSave(csvRecords);
    }
}
