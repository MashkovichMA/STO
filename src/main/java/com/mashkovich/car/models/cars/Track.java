package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "track")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Track extends Car {
	@XmlElement(name = "carrying")
	@JsonProperty("carrying")
	private int carrying;
	public Track() {}
	private static final Logger log = Logger.getLogger(Track.class);
	public Track(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash, int carrying) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance, crash);
		this.carrying = carrying;
		log.info ("gruzopodjomnost "+ getCarrying());
	}	
	public abstract void transport();
	public int getCarrying() {
		return carrying;
	}
	public void setCarrying(int carrying) {
		this.carrying = carrying;
	}
}
