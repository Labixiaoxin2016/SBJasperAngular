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
@Table(value = "sales")
//@IdClass(value=SalesKeyId.class)
public class Sales {

//	@PrimaryKeyColumn(name="pkey1",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String pkey1;

//	@PrimaryKeyColumn(name="pkey2",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private String pkey2;

//	@PrimaryKeyColumn(name = "s_id",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
	@Id
	@Column(value = "s_id")
	private String sId;

	@Id
	@Column(value = "s_date")
	private String sDate;

	@Column(value = "s_value")
    private int sValue;

}
