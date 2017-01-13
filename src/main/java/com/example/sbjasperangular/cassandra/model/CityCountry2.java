package com.example.sbjasperangular.cassandra.model;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "city_country")
//@IdClass(value=CityCountry2KeyId.class)
public class CityCountry2 implements Serializable {

//	@Id
	private String pkey1;
//	@Id
	private String pkey2;
	@Id
	private String name;

    private Long population;

    private String countryName;

}
