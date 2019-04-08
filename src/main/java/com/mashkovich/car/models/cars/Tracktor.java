package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "tracktor")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "tracktor")
public class Tracktor extends Track {
	@XmlElement(name = "trailer")
	@JsonProperty("trailer")
	private String trailer;
	public Tracktor() {}
	private static final Logger log = Logger.getLogger(Tracktor.class);
	public Tracktor(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash,
			int carrying, String trailer) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, carrying);
		this.trailer = trailer;
		log.info ("pricep "+ getTrailer());
	}
	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public void transport() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void ride() {
		// TODO Auto-generated method stub	
	}
}
