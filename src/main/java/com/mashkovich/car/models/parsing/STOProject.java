package com.mashkovich.car.models.parsing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashkovich.car.models.sto.Client;
import com.mashkovich.car.models.sto.STOForCars;
import com.mashkovich.car.models.sto.STOForElectrocar;
import com.mashkovich.car.models.sto.STOForTrucks;

@XmlRootElement(name = "stoProject")
@XmlAccessorType(XmlAccessType.FIELD)
public class STOProject {
	@JsonProperty("client")
	private Client client;
	@JsonProperty("stoForCars")
	private STOForCars stoForCars;
	@JsonProperty("stoForElectrocar")
	private STOForElectrocar stoForElectrocar;
	@JsonProperty("stoForTrucks")
	private STOForTrucks stoForTrucks;
	public STOProject() {}
	public String toString() {
		return client.toString()+"  "+stoForCars.toString()+"  "+stoForElectrocar.toString()+"  " +stoForTrucks.toString();
	}
	public STOForCars getStoForCars() {
		return stoForCars;
	}
	public void setStoForCars(STOForCars stoForCars) {
		this.stoForCars = stoForCars;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public STOForElectrocar getStoForElectrocar() {
		return stoForElectrocar;
	}
	public void setStoForElectrocar(STOForElectrocar stoForElectrocar) {
		this.stoForElectrocar = stoForElectrocar;
	}
	public STOForTrucks getStoForTrucks() {
		return stoForTrucks;
	}
	public void setStoForTrucks(STOForTrucks stoForTrucks) {
		this.stoForTrucks = stoForTrucks;
	}
}
