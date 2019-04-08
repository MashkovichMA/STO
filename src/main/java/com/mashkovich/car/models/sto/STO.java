package com.mashkovich.car.models.sto;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashkovich.car.models.cars.Cabriolet;
import com.mashkovich.car.models.cars.Car;
import com.mashkovich.car.models.cars.Crossover;
import com.mashkovich.car.models.cars.DumpTruck;
import com.mashkovich.car.models.cars.Electrocar;
import com.mashkovich.car.models.cars.ISTORepair;
import com.mashkovich.car.models.cars.Minivan;
import com.mashkovich.car.models.cars.PassengerCarReal;
import com.mashkovich.car.models.cars.Pickup;
import com.mashkovich.car.models.cars.Tracktor;
import com.mashkovich.car.models.cars.Truck;

@XmlRootElement(name = "sto")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class STO implements ISTORepair{
	@XmlElement(name = "name")
	@JsonProperty("name")
	private String name;
	@XmlElement(name = "address")
	@JsonProperty("address")
	private Address address;
	@XmlElement(name = "numberOfPosts")
	@JsonProperty("numberOfPosts")
	private int numberOfPosts;
	@XmlElementWrapper (name = "cars")
	@XmlElements( { 
		@XmlElement( name="passengerCarReal", type = PassengerCarReal.class ),
		@XmlElement( name="cabriolet", type = Cabriolet.class),
		@XmlElement( name="crossover", type = Crossover.class ), 
		@XmlElement( name="minivan", type = Minivan.class ),
		@XmlElement( name="pickup", type = Pickup.class),
		@XmlElement( name="electrocar", type = Electrocar.class ), 
		@XmlElement( name="dumpTruck", type = DumpTruck.class ),
		@XmlElement( name="truck", type = Truck.class ), 
		@XmlElement( name="tracktor", type = Tracktor.class )
		} )
	@JsonIgnore
	//@JsonDeserialize(as = PassengerCarReal.class)
	private List<Car> cars ;
	public STO() {}
	public STO (String name, int numberOfPosts, Address address) { 
		this.name = name;
		this.numberOfPosts = numberOfPosts;
		this.address = address;
	}

	private static final Logger log = Logger.getLogger(STO.class);
	public double repair(int cost) {
		int a = cars.size();
		if (a<=numberOfPosts) {
			cost = 2*cost;
			log.info("remont proizveden, schet = " + cost);
				if (a>numberOfPosts) {
					log.info("mest net");
					}
		}
		return cost;
				
				}		
	public String toString() {
		return name+" " + "address:" + address.getCountry()+","+address.getCity()+","+address.getStreet()+","+address.getHouse()+"  number of posts = "+numberOfPosts + "  cars = " + cars;//cars1
	}
	public void numberOfCars() {
}
	public void giveBill() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumberOfPosts() {
	return numberOfPosts;
}
public void setNumberOfPosts(int numberOfPosts) {
	this.numberOfPosts = numberOfPosts;
}

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<Car> getCars() {
	return cars;
}
public void setCars(List<Car> cars) {
	this.cars = cars;
}
}
		
		