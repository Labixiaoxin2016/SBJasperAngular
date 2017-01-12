package com.example.sbjasperangular.cassandra.model;



import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "city_country")
public class CityCountry  {

	@PrimaryKeyColumn(name="pkey1",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String pkey1;

	@PrimaryKeyColumn(name="pkey2",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private String pkey2;

	@PrimaryKeyColumn(name = "name",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
	private String name;

    @Column()
    private Long population;

    @Column()
    private String countryName;

}
