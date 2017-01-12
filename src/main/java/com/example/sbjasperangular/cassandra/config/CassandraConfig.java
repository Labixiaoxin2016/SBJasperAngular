package com.example.sbjasperangular.cassandra.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@PropertySource(value = {"classpath:META-INF/cassandra_keyspaceC.properties"})
@EnableCassandraRepositories(basePackages = {"com.example.sbjasperangular.cassandra"})
public class CassandraConfig {
	@Autowired
    private Environment environment;
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfig.class);
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        return cluster;
    }
    @Bean
    public CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }
    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }
    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(environment.getProperty("cassandra.keyspace"));
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }
    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    @Bean
    public ObjectMapper objectMapper() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(df);
        return mapper;
    }

    // https://github.com/hidetarou2013/spring-data-examples/blob/master/cassandra/java8/src/main/java/example/springdata/cassandra/java8/CassandraConfiguration.java
    @Configuration
	@EnableCassandraRepositories
	static class CassandraInnerConfig extends AbstractCassandraConfiguration {

		@Override
		public String getKeyspaceName() {
			return "keyspaceC";
		}

		@Override
		public SchemaAction getSchemaAction() {
			return SchemaAction.RECREATE;
		}
	}
}
