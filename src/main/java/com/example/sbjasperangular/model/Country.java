package com.example.sbjasperangular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    private static final long serialVersionUID = 7215298992738155751L;

    @Id
    private String name;

    // fetch = FetchType.EAGER LAZY
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<City>();

// lombokを使うことで記載が減る。-------------------------------
//    public String getName() {
//	return name;
//    }
//
//    public Country setName(String name) {
//	this.name = name;
//	return this;
//    }
//
//    public List<City> getCities() {
//	return cities;
//    }
//
//    public Country setCities(List<City> cities) {
//	this.cities = cities;
//	return this;
//    }
//
    public Country addCity(City city) {
	if (!cities.contains(city)) {
	    cities.add(city);
	}
	return this;
    }

}
