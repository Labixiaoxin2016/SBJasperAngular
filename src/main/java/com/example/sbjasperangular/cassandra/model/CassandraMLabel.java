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
@Table(value = "M_LABEL")
public class CassandraMLabel {

//	@PrimaryKeyColumn(name="pkey1",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String pkey1;

//	@PrimaryKeyColumn(name="pkey2",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private String pkey2;

//	@PrimaryKeyColumn(name = "label_id",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
	@Id
	@Column(value = "label_id")
	private String labelId ;

	@Column(value = "label_name")
    private String labelName;

    @Column(value = "parent_label_id")
    private Long parentLabelId;

}
