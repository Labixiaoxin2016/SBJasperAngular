package com.example.sbjasperangular.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.example.sbjasperangular.cassandra.model.CassandraCity;
import com.example.sbjasperangular.cassandra.model.CassandraCityCountry;
import com.example.sbjasperangular.cassandra.model.CassandraCountry;
import com.example.sbjasperangular.cassandra.model.CassandraMLabel;
import com.example.sbjasperangular.model.City;
import com.example.sbjasperangular.model.Country;
import com.example.sbjasperangular.model.MLabel;
import com.example.sbjasperangular.model.MemoBox;



@Configuration
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	config.exposeIdsFor(City.class, Country.class,CassandraCityCountry.class,CassandraCity.class,CassandraCountry.class,MLabel.class,MemoBox.class,CassandraMLabel.class);
//	config.setBaseUri("/rest");// メソッド setBaseUri(String) は型 RepositoryRestConfiguration で未定義です
	config.setBasePath("/rest");



    }
}
