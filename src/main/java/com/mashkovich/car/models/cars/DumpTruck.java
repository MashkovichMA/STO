package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "dumpTruck")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "dumpTruck")
public class DumpTruck extends Track {
	@XmlElement(name = "tailBoard")
	@JsonProperty("tailBoard")
	private String tailBoard;
	public DumpTruck() {}
	private static final Logger log = Logger.getLogger(DumpTruck.class);
	public DumpTruck(String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance,Crash crash,
			int carrying, String tailBoard) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance,crash, carrying);
		this.tailBoard = tailBoard;
		log.info ("otkidnoy bort "+ getTailBoard());
	}
	public String getTailBoard() {
		return tailBoard;
	}
	public void setTailBoard(String tailBoard) {
		this.tailBoard = tailBoard;
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
