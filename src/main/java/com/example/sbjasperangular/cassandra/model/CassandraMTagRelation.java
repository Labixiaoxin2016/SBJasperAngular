package com.example.sbjasperangular.cassandra.model;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "m_tag_relation")
public class CassandraMTagRelation implements Serializable{

//	@PrimaryKeyColumn(name="pkey1",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String pkey1;

//	@PrimaryKeyColumn(name="pkey2",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private String pkey2;

//	@PrimaryKeyColumn(name = "tag_id",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
	@Id
	@Column(value = "tag_id")
	private Integer tagId ;

	@Column(value = "tag_name")
    private String tagName;

    @Column(value = "parent_tag_id")
    private Integer parentTagId;

    @Column(value = "attribute")
    private String attribute;

    @Column(value = "color")
    private String color;

    @Column(value = "target_id")
    private String targetId;
}
