package com.mashkovich.car.models.cars;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@XmlRootElement(name = "crash")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "crash")
public class Crash {
	@XmlElement(name = "name")
	@JsonProperty("name")
	private String  name;
	@XmlElement(name = "number")
	@JsonProperty("number")
	private int number;
	@XmlElement(name = "cost")
	@JsonProperty("cost")
	private int cost;
	public Crash() {}
	public Crash (String name, int number) {
		this.name = name;
		this.number = number;
}
	public String chooseName() {
		String [] array = {"engine","door","bamper","window","roof","coal"};
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (String word : array) {	
			map.put(i++, word);
			}		
		i = (1 + (int) (Math.random()*6));
		String crash = map.get(i);
		return crash;
	}
	public void happen() {
		setCost(500 + (int) (Math.random()*5000));
		cost=(getCost()*getNumber());
	}
	public String getName() {
		return name;
	}
	public void setName(String g) {
		this.name = g;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
