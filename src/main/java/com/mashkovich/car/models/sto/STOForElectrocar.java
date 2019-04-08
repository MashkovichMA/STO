package com.mashkovich.car.models.sto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.mashkovich.car.models.sto.Address;

@XmlRootElement(name = "stoForElectroCar")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "stoForElectrocar")
public class STOForElectrocar extends STO {
	@XmlElement(name = "highVSocket")
	@JsonProperty("highVSocket")
	private int highVSocket;
	@XmlElement(name = "newBattery")
	@JsonProperty("newBattery")
	private int newBattery;
	public STOForElectrocar() {}
	public STOForElectrocar(String name, int numberOfPosts, Address address) {
		super(name, numberOfPosts, address);
		this.highVSocket = highVSocket ;
		this.newBattery = newBattery;
	}
	@Override
	public void repair() {
		// TODO Auto-generated method stub	
	}
	public int getHighVSocket() {
		return highVSocket;
	}
	public void setHighVSocket(int highVSocket) {
		this.highVSocket = highVSocket;
	}
	public int getNewBattery() {
		return newBattery;
	}
	public void setNewBattery(int newBattery) {
		this.newBattery = newBattery;
	}
		}



