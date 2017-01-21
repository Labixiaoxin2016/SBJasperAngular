package com.example.sbjasperangular.cassandra.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "cassandra_country")
public class CassandraCountry {

//	@PrimaryKeyColumn(name="pkey1",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String pkey1;

//	@PrimaryKeyColumn(name="pkey2",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private String pkey2;

//	@PrimaryKeyColumn(name = "name",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
	@Id
	private String id;

    @Column(value = "name")
    private String name;

}
