package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "crossover")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "crossover")
public class Crossover extends PassengerCar {
	@XmlElement(name = "fourwheelDrive")
	@JsonProperty("fourwheelDrive")
	private String fourwheelDrive;
	public Crossover() {}
	private static final Logger log = Logger.getLogger(Crossover.class);
	public Crossover(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash,
			int numberOfPassengers,String fourwheelDrive ) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance, crash, numberOfPassengers);
		this.fourwheelDrive = fourwheelDrive;
		log.info ("polnuy privod "+ getFourwheelDrive());	
	}
	public String getFourwheelDrive() {
		return fourwheelDrive;
	}
	public void setFourwheelDrive(String fourwheelDrive) {
		this.fourwheelDrive = fourwheelDrive;
	}
}
