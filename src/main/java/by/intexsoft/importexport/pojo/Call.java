package by.intexsoft.importexport.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Call {
    @PrimaryKey
    private UUID uuid;
    private Date date;

}
