package com.mashkovich.car.models.sto;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "address")
public class Address {
	@XmlElement(name = "country")
	@JsonProperty("country")
	private String country;
	@XmlElement(name = "city")
	@JsonProperty("city")
	private String city;
	@XmlElement(name = "street")
	@JsonProperty("street")
	private String street;
	@XmlElement(name = "house")
	@JsonProperty("house")
	private int house;
	@XmlElement(name = "flat")
	@JsonProperty("flat")
	private int flat;
	public Address() {}
	public Address (String country, String city, String street, int house, int flat) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;	
}
	public String toString() {
		return "country-" + country+" " + "city-" + city+" " + "street-" + street+" "+ "house-" + house+" " + "flat-" + flat; 
	}
	@Override
	public int hashCode() {
		final int prime =31;
		int result = 1;
		result = prime * result + house;
		result = prime * result + flat;
		return result;
	}
	@Override
	public boolean equals (Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass()!=this.getClass()) {
			return false;
			
		}
		Address a = (Address) obj;
		if((this.country==null) ? (a.country!=null) :this.country.equals(a.country)) {
			return false;
		}
		if ((this.city==null) ? (a.city!=null) :this.city.equals(a.city)) {
			return false;
		}
		if ((this.street==null) ? (a.street!=null) :this.street.equals(a.street)) {
			return false;
		}
		if (a.house!= this.house && a.flat!=this.flat) { 
			return false;}
			return true;
	
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public int getHouse() {
	return house;
}
public void setHouse(int house) {
	this.house = house;
}
public int getFlat() {
	return flat;
}
public void setFlat(int flat) {
	this.flat = flat;
}
}
