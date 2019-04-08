package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "truck")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "truck")
public class Truck extends Track {
	@XmlElement(name = "body")
	@JsonProperty("body")
	private String body;
	public Truck() {}
	private static final Logger log = Logger.getLogger(Truck.class);
	public Truck(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash,
			int carrying, String body ) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, carrying);
		this.body = body;
		log.info ("kuzov "+ getBody());
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
