package com.mashkovich.car.models.sto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mashkovich.car.models.cars.Car;
import com.mashkovich.car.models.cars.Crash;
import com.mashkovich.car.models.cars.Insurance;
import com.mashkovich.car.models.cars.PassengerCarReal;
import com.mashkovich.car.models.exceptions.MinusExperienceException;
import com.mashkovich.car.models.exceptions.NullAgeException;

public class Runner {
	private static final Logger log = Logger.getLogger(Runner.class);
	public static void main(String[] args) throws Exception {
		Insurance insurance = new Insurance ();
		insurance.setDriverAge(25);
		insurance.setDriverExperience(3);
		try {
			insurance.giveCost();
			}
			catch (NullAgeException e) {
				log.info(e.getMessage());
				}
			catch (MinusExperienceException f) {
			log.info(f.getMessage());	
			}
		insurance.getDriverAge();
		insurance.setDate("2018-12-10");
		Crash crash = new Crash();
		crash.setNumber(1);
		crash.happen();
		crash.setName(crash.chooseName());
		PassengerCarReal passengerCarReal = new PassengerCarReal();
		passengerCarReal.setModel("BMW");
		passengerCarReal.setYear("2006");
		passengerCarReal.setCostOfCar(2000);
		passengerCarReal.setInsurance(insurance);
		passengerCarReal.setCrash(crash);
		Address a = new Address ();
		a.setCountry("Belarus");
		a.setCity("Minsk");
		a.setStreet("Lenina");
		a.setHouse(15);
		STOForCars stoForCars = new STOForCars ("STO100 ",5, a);
		stoForCars.setNumberOfPosts(5);
		List<Car> cars = new ArrayList<>();
		cars.add(passengerCarReal);
		stoForCars.setCars(cars);
		log.info(stoForCars.toString());	
		try (Client ivan = new Client()){
		ivan.setMoney(50000);
		ivan.payBill(stoForCars.repair(crash.getCost()));	
		}
	}
}
