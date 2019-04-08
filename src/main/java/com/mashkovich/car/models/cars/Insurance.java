package com.mashkovich.car.models.cars;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.mashkovich.car.models.exceptions.MinusExperienceException;
import com.mashkovich.car.models.exceptions.NullAgeException;
@XmlRootElement(name = "insurance")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "insurance")
public class Insurance {
	@XmlElement(name = "validity")
	@JsonProperty("validity")
	private String validity;
	@XmlElement(name = "driverAge")
	@JsonProperty("driverAge")
	private int driverAge;
	@XmlElement(name = "driverExperience")
	@JsonProperty("driverExperience")
	private int driverExperience;
	@XmlElement(name = "data")
	@JsonProperty("data")
	private Date date;
	public Insurance() {}
	public Insurance (String validity, int driverAge, int driverExperience) {
		this.validity = validity;
		this.driverAge = driverAge;
		this.driverExperience = driverExperience;
	}
	public String toString() {
		return  "validity - " + validity+" " + "driverAge - " + driverAge+" driver experience - "+ driverExperience + " date - "+ date ;
	}
	public void giveCost() throws NullAgeException,  MinusExperienceException {
		if(driverAge <=0) {
				throw new NullAgeException("Incorrect age");
				}
		if(driverExperience <0) {
				throw new MinusExperienceException("Incorrect experience value");
			} 
			
		 double costOfInsurance = 500;
		 
			if (driverAge<=22||driverExperience<=3) {
				costOfInsurance = costOfInsurance*1.7;
			}
			else
			if (driverAge<=22||driverExperience>3) {
				costOfInsurance = costOfInsurance*1.3;	
			}
			else
			if (driverAge>22||driverExperience<=3) {
				costOfInsurance = costOfInsurance*1.5;	
			}
			else
			if (driverAge>22||driverExperience>3) {
				costOfInsurance = costOfInsurance*1;	
			}
		}
			
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + driverAge;
		result = prime * result + driverExperience;
		result = prime * result + ((validity == null) ? 0 : validity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.hashCode()!=obj.hashCode())
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (driverAge != other.driverAge)
			return false;
		if (driverExperience != other.driverExperience)
			return false;
		if (validity == null) {
			if (other.validity != null)
				return false;
		} else if (!validity.equals(other.validity))
			return false;
		return true;
	}	
	
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		
		this.validity = validity;
	}
	public int getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(int driverAge) {	
		this.driverAge = driverAge;
	}
	public int getDriverExperience(int driverExperience) {
		return driverExperience;
	}
	public void setDriverExperience(int driverExperience) {
		this.driverExperience = driverExperience;
	
	}
	private SimpleDateFormat f = new SimpleDateFormat("yyyy-dd-MM");
	public String getDate() {
		return f.format(date);
	}
	public void setDate(String date) throws Exception{
		this.date = f.parse (date);
	}
	
}