package com.example.sbjasperangular.cassandra.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.example.sbjasperangular.cassandra.model.CityCountry2;
import com.example.sbjasperangular.cassandra.model.Person;



@Configuration
public class CassndraRepositoryConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	config.exposeIdsFor(Person.class,CityCountry2.class);
//	config.setBaseUri("/rest");// メソッド setBaseUri(String) は型 RepositoryRestConfiguration で未定義です
	config.setBasePath("/rest_repository");



    }
}
