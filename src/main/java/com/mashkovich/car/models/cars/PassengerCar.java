package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "passengerCar")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class PassengerCar extends Car {
	@XmlElement(name = "numberOfPassengers")
	protected int numberOfPassengers;
	public PassengerCar() {}
	public PassengerCar(String model, String year, int enginePower, int lenght, int width, int costOfCar,
			Insurance insurance, Crash crash, int numberOfPassengers ) {
		super(model, year, enginePower, lenght, width, costOfCar, insurance, crash);
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	@Override
	public void ride() {
	}
}
