package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "cabriolet")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "cabriolet")
public class Cabriolet extends PassengerCar{
	@XmlElement(name = "retractableRoof")
	@JsonProperty("retractableRoof")
	private String retractableRoof;
	public Cabriolet() {}
	private static final Logger log = Logger.getLogger(Cabriolet.class);
	public Cabriolet(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash,
			int numberOfPassengers, String retractableRoof) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, numberOfPassengers);
		this.retractableRoof = retractableRoof;
		log.info ("otkidnoy verh "+ getRetractableRoof());	
	}
	public String getRetractableRoof() {
		return retractableRoof;
	}
	public void setRetractableRoof(String retractableRoof) {
		this.retractableRoof = retractableRoof;
	}
}
