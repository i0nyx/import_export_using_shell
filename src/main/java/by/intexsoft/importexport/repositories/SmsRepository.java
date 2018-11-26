package by.intexsoft.importexport.repositories;

import by.intexsoft.importexport.pojo.Sms;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepository extends CassandraRepository<Sms, Integer> {
}
