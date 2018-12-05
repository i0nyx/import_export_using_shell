package by.intexsoft.importexport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Objects;


@Configuration
@PropertySource("classpath:cassandra.properties")
@ComponentScan("by.intexsoft.importexport")
@EnableCassandraRepositories(basePackages = {"by.intexsoft.importexport.repositories"})
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Value("${cassandra.host}")
    private String cassandraHost;
    @Value("${cassandra.port}")
    private int cassandraPort;
    @Value("${cassandra.keyspace}")
    private String cassandraSchema;

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getKeyspaceName() {
        return cassandraSchema;
    }

    /**
     * Create a {@link CassandraClusterFactoryBean}.
     */
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(cassandraHost);
        cluster.setPort(cassandraPort);
        return cluster;
    }

    /**
     * Create a {@link CassandraMappingContext}
     */
    @Bean
    public CassandraMappingContext mappingContext() {
        return new CassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(Objects.requireNonNull(cluster().getObject()));
        session.setKeyspaceName(getKeyspaceName());
        session.setConverter(converter());
        session.setSchemaAction(getSchemaAction());
        return session;
    }

    @Bean
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE;
    }
}