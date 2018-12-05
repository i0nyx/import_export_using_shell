package by.intexsoft.importexport.shell;

import by.intexsoft.importexport.service.ExportEventService;
import by.intexsoft.importexport.service.ImportEventService;
import lombok.AllArgsConstructor;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class ShellCommand implements CommandMarker {
    private final ImportEventService importService;
    private final ExportEventService exportService;

    @CliCommand(value="import", help = "import events to database")
    public String importCsv(@CliOption(key={"p"}, mandatory = true, help = "enter path to file")final String path) throws IOException {
        importService.checkAndImport(path);
        return "import success";
    }

    @CliCommand(value="export", help="export events of database")
    public String exportToCsv(@CliOption(key={"e"}, mandatory = true, help = "specify event type for export")final String eventType) throws IOException {
        exportService.exportToCsv(eventType);
        return "export success";
    }
}
