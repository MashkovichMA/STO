package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "passengerCarReal")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "passengerCarReal")
public class PassengerCarReal extends PassengerCar {
	public PassengerCarReal() {}
	public PassengerCarReal(String model, String year, int enginePower, int lenght, int width, int costOfCar,
			Insurance insurance, Crash crash, int numberOfPassengers) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance, crash, numberOfPassengers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ride() {
	}
}