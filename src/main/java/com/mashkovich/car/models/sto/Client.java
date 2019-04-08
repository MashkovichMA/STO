package com.mashkovich.car.models.sto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.mashkovich.car.models.exceptions.MoneyNotFoundException;
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "client")
public class Client implements AutoCloseable {
	@XmlElement(name = "name")
	@JsonProperty("name")
	private String name;
	@XmlElement(name = "address")
	@JsonProperty("address")
	private Address address;
	@XmlAttribute(name = "money")
	@JsonProperty("money")
	private double money;	
	public Client() {}
	public Client(String name, Address address, double money) {
		this.name = name;
		this.address = address;
		this.money = money;
	}
	private static final Logger log = Logger.getLogger(Runner.class);
	public String toString() {
		return name+"   " + "address:" + address.getCountry()+","+address.getCity()+","+address.getStreet()+","+address.getHouse()+"/"+address.getFlat()+ "   "+"money:"+money;
	}
	public void payBill(double cost) {
		if (cost!=0) {
			if (money<0) {
				try {
					throw new MoneyNotFoundException("Incorrect sum of money");
				} catch (MoneyNotFoundException e) {
					log.info(e.getMessage());			
				}
			}	
				if (money>=cost) {
					log.info("bill paid " + "zaberite mashiny");
					money = money - cost;
					}
				else 
					log.info("bill not paid "	+ "oplatity chet!");
					}		
			}
	public double getMoney() {
	return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		
			
		}
	@Override
	public void close(){
	}
}