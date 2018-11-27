package by.intexsoft.importexport.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
public class Sms extends Event {
    @PrimaryKey
    private UUID uuid;
    private Date date;
}
