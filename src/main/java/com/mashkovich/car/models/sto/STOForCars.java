package com.mashkovich.car.models.sto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.mashkovich.car.models.sto.Address;
@XmlRootElement(name = "stoForCars")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "stoForCars")
public class STOForCars extends STO {
public STOForCars() {}
	public STOForCars(String name,int numberOfPosts, Address address) {
		super(name,numberOfPosts, address);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void repair() {
		// TODO Auto-generated method stub
	}
	}
		
	

