package com.mashkovich.car.models.sto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.mashkovich.car.models.sto.Address;
@XmlRootElement(name = "stoForTrucks")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "stoForTrucks")
public class STOForTrucks extends STO {
	@XmlElement(name = "heavyWeightStand")
	@JsonProperty("heavyWeightStand")
	public int heavyWeightStand;
	@XmlElement(name = "cargoLift")
	@JsonProperty("cargoLift")
	public int cargoLift;
	public STOForTrucks() {}
	public STOForTrucks(String name,int numberOfPosts, Address address) {
		super(name, numberOfPosts, address);
		this.heavyWeightStand = this.heavyWeightStand;
		this.cargoLift = cargoLift;
	}
	@Override
	public void repair() {
		// TODO Auto-generated method stub
	}	
	public int getHeavyWeightStand() {
		return heavyWeightStand;
	}
	public void setHeavyWeightStand(int heavyWeightStand) {
		this.heavyWeightStand = heavyWeightStand;
	}
	public int getCargoLift() {
		return cargoLift;
	}
	public void setCargoLift(int cargoLift) {
		this.cargoLift = cargoLift;
	}	
}
		

