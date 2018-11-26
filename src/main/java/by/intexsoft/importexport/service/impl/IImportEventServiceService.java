package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.Util.StringUtil;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.CsvService;
import by.intexsoft.importexport.service.EventService;
import by.intexsoft.importexport.service.ImportEventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class IImportEventServiceService implements ImportEventService {
    private final CsvService csvService;
    private final EventService eventService;

    @Override
    public void checkAndImport(String path) throws IOException {
        TypeEvent type = TypeEvent.valueOf(StringUtil.getStringType(path));
        List lists = csvService.readCsvAndConvertToBean(new FileReader(path), type);

    }
}
