package by.intexsoft.importexport.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public abstract class Event {
    private UUID uuid;
    private LocalDate date;
}
