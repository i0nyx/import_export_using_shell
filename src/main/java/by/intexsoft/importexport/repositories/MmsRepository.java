package by.intexsoft.importexport.repositories;

import by.intexsoft.importexport.pojo.Mms;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MmsRepository extends CassandraRepository<Mms, Integer> {
}
