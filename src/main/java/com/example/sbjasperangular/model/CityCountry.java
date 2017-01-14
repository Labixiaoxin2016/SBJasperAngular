package com.example.sbjasperangular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityCountry implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long population;

    @Column(name = "country_name",nullable = false)
    private String countryName;

}
