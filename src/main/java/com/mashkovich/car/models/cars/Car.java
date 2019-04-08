package com.mashkovich.car.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Car {
	@XmlElement(name = "model")
	@JsonProperty("model")
	private String model;
	@XmlElement(name = "year")
	@JsonProperty("year")
	private String year;
	@XmlElement(name = "enginePower")
	@JsonProperty("enginePower")
	private int enginePower;
	@XmlElement(name = "lenght")
	@JsonProperty("lenght")
	private int lenght;
	@XmlElement(name = "width")
	@JsonProperty("width")
	private int width;
	@XmlElement(name = "costOfCar")
	@JsonProperty("costOfCar")
	private int costOfCar;
	@XmlElement(name = "insurance")
	@JsonProperty("insurance")
	private Insurance insurance;
	@XmlElement(name = "crash")
	@JsonProperty("crash")
	private Crash crash;
	public Car () {}
	public Car (String model, String year, int enginePower, int lenght, int width, int costOfCar, Insurance insurance, Crash crash) {
		this.model = model;
		this.year = year;
		this.costOfCar = costOfCar;
		this.insurance = insurance;
		this.crash = crash;
	}
	public abstract void ride();
	public String toString() {
		return "model-" + model+" " + "year-" + year+" " + "costOfCar-" + costOfCar+" "+ "insurance:" + insurance+ ", detal-" + crash.getName()+" " + "kol-vo- " + crash.getNumber()+ "cost- " + crash.getCost() ;
	}
	public double insuraning () {
		return costOfCar;
		}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;

	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getCostOfCar() {
		return costOfCar;
	}
	public void setCostOfCar(int costOfCar) {
		this.costOfCar = costOfCar;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Crash getCrash() {
		return crash;
	}
	public void setCrash(Crash crash) {
		this.crash = crash;
	}
}

