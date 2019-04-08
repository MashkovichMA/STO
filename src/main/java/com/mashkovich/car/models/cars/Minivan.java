package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "minivan")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "minivan")
public class Minivan extends PassengerCar {
	@XmlElement(name = "extraSeats")
	@JsonProperty("extraSeats")
	private int extraSeats;
	public Minivan() {}
	private static final Logger log = Logger.getLogger(Minivan.class);
	public Minivan(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash,
			int numberOfPassengers, int extraSeats ) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, numberOfPassengers);
		this.extraSeats = extraSeats;
		log.info ("dopolnitelnye mesta "+ getExtraSeats());
	}
	public int getExtraSeats() {
		return extraSeats;
	}
	public void setExtraSeats(int extraSeats) {
		this.extraSeats = extraSeats;
	}


}
