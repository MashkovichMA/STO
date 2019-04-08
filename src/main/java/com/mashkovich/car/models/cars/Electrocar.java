package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "electrocar")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "electrocar")
public class Electrocar extends PassengerCar {
	@XmlElement(name = "battery")
	@JsonProperty("battery")
	private String battery;
	public Electrocar() {}
	private static final Logger log = Logger.getLogger(Electrocar.class);
	public Electrocar(String model, String year, int enginePower, int lenght, int width, int costOfCar,
			Insurance insurance,Crash crash, int numberOfPassengers, String battery) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, numberOfPassengers);
		this.battery = battery;
		log.info ("batareya "+ getBattery());
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
}
