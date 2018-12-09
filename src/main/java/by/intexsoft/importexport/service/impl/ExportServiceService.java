package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.service.ICsvService;
import by.intexsoft.importexport.service.IExportEventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ExportServiceService implements IExportEventService {
    private final ICsvService ICsvService;

    public void exportToCsv(final String typeStr) throws IOException {
        String csvName = String.format("D:/%s_%t.csv", typeStr.toUpperCase(), LocalDate.now());
        FileWriter writer = new FileWriter(csvName);
        ICsvService.writeCsv(writer, TypeEvent.valueOf(typeStr.toUpperCase()));
    }
}
