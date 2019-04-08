package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "pickup")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "pickup")
public class Pickup extends PassengerCar{
	@XmlElement(name = "cargoPlatform")
	@JsonProperty("cargoPlatform")
	private String cargoPlatform;
	public Pickup() {}
	private static final Logger log = Logger.getLogger(Pickup.class);
	public Pickup(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance,Crash crash,
			int numberOfPassengers, String cargoPlatform) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, numberOfPassengers);
		this.cargoPlatform = cargoPlatform;
		log.info ("gruzovaya platforma "+ getCargoPlatform());
	}
	public String getCargoPlatform() {
		return cargoPlatform;
	}
	public void setCargoPlatform(String cargoPlatform) {
		this.cargoPlatform = cargoPlatform;
	}
}