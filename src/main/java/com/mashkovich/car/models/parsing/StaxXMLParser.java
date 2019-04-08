package com.mashkovich.car.models.parsing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.Logger;

import com.mashkovich.car.models.cars.Cabriolet;
import com.mashkovich.car.models.cars.Car;
import com.mashkovich.car.models.cars.Crash;
import com.mashkovich.car.models.cars.Crossover;
import com.mashkovich.car.models.cars.DumpTruck;
import com.mashkovich.car.models.cars.Electrocar;
import com.mashkovich.car.models.cars.Insurance;
import com.mashkovich.car.models.cars.Minivan;
import com.mashkovich.car.models.cars.PassengerCarReal;
import com.mashkovich.car.models.cars.Pickup;
import com.mashkovich.car.models.cars.Tracktor;
import com.mashkovich.car.models.cars.Truck;
import com.mashkovich.car.models.sto.Address;
import com.mashkovich.car.models.sto.Client;
import com.mashkovich.car.models.sto.Runner;
import com.mashkovich.car.models.sto.STOForCars;
import com.mashkovich.car.models.sto.STOForElectrocar;
import com.mashkovich.car.models.sto.STOForTrucks;
import javax.xml.stream.events.Attribute;

import javax.xml.namespace.QName;


public class StaxXMLParser  {
	 private static final Logger log = Logger.getLogger(Runner.class);
	 private static void parseXML(String fileName) throws Exception {
		 STOForCars stoForCars = null;
		 STOForElectrocar stoForElectrocar = null;
		 STOForTrucks stoForTrucks = null;
		 PassengerCarReal passengerCarReal = null;
		 Cabriolet cabriolet = null;
		 Crossover crossover = null;
		 Minivan minivan = null;
		 Pickup pickup = null;
		 Electrocar electrocar = null;
		 DumpTruck dumpTruck = null;
		 Truck truck = null;
		 Tracktor tracktor = null;
		 List <Car> cars = new ArrayList <Car>();
		 List <Car> cars1 = new ArrayList <Car>();
		 List <Car> cars2 = new ArrayList <Car>();
		 Client client = null;
		 XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	        try {
	            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
	            while(xmlEventReader.hasNext()){
	                XMLEvent xmlEvent = xmlEventReader.nextEvent();
	                if (xmlEvent.isStartElement()){
		                   StartElement startElement = xmlEvent.asStartElement();
		                   switch(startElement.getName().getLocalPart()) {
		                   		case "stoForCars":{	
		                   			xmlEvent = xmlEventReader.nextTag();	
		                   			stoForCars = parseSTOForCars(xmlEvent, xmlEventReader);
		                   		}
		        	        	break;
		                   		case "passengerCarReal":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			passengerCarReal = parsePassengerCarReal(xmlEvent, xmlEventReader);
		                   			cars.add(passengerCarReal);
		                   		}
		                   		break;
		                   		case "cabriolet":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			cabriolet = parseCabriolet(xmlEvent, xmlEventReader);
		                   			cars.add(cabriolet);
		                   		}
		                   		break;
		                   		case "crossover":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			crossover = parseCrossover(xmlEvent, xmlEventReader);
		                   			cars.add(crossover);
		                   		 
		                   		}
		                   		break;
		                   		case "minivan":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			minivan = parseMinivan(xmlEvent, xmlEventReader);
		                   			cars.add(minivan);
		                   		}
		                   		break;
		                   		case "pickup":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			pickup = parsePickup(xmlEvent, xmlEventReader);
		                   			cars.add(pickup);
		                   			stoForCars.setCars(cars);
		                   		}
		                   		break;
		                   		case "stoForElectrocar":{	
		                   			xmlEvent = xmlEventReader.nextTag();	
		                   			stoForElectrocar = parseSTOForElectrocar(xmlEvent, xmlEventReader);
		                   		}
		                   		break;
		                   		case "electrocar":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			electrocar = parseElectrocar(xmlEvent, xmlEventReader);
		                   			cars1.add(electrocar);
		                   			stoForElectrocar.setCars(cars1);
		                   		}
		                   		break;
		                   		case "stoForTrucks":{	
		                   			xmlEvent = xmlEventReader.nextTag();	
		                   			stoForTrucks = parseSTOForTrucks(xmlEvent, xmlEventReader);
		                   		}
		                   		break;
		                   		case "dumpTruck":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			dumpTruck = parseDumpTruck(xmlEvent, xmlEventReader);
		                   			cars2.add(dumpTruck);
		                   		}
		                   		break;
		                   		case "truck":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			truck = parseTruck(xmlEvent, xmlEventReader);
		                   			cars2.add(truck);
		                   		}
		                   		break;
		                   		case "tracktor":{	
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			tracktor = parseTracktor(xmlEvent, xmlEventReader);
		                   			cars2.add(tracktor);
		                   			stoForTrucks.setCars(cars);
		                   		}
		                   		break;
		                   		case "client":{	
		                   			Attribute moneyAttr = startElement.getAttributeByName(new QName("money"));	                   			
		                            int money=Integer.parseInt(moneyAttr.getValue());
		                   			xmlEvent = xmlEventReader.nextTag();
		                   			client = parseClient(xmlEvent, xmlEventReader);
		                   			client.setMoney(money);
		                   			log.info(stoForCars.toString());
		                   			log.info(stoForElectrocar.toString());
		                   			log.info(stoForTrucks.toString());
		                   			log.info(client.toString());
		                   		}
		                   		break;
		                   }
	                }
	               
	            }   
            
        } catch (FileNotFoundException | XMLStreamException e) {
        	 e.printStackTrace();
        }         
}
	 
	 private static STOForCars parseSTOForCars(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			STOForCars stoForCars = new STOForCars();
			Address address = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "name":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForCars.setName(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}	
	        	case "numberOfPosts":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForCars.setNumberOfPosts(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "address":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		address = parseSTOAddress(xmlEvent, xmlEventReader);
	        		stoForCars.setAddress(address);	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return stoForCars; 
	    }
	 private static PassengerCarReal parsePassengerCarReal(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			PassengerCarReal passengerCarReal = new PassengerCarReal();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		passengerCarReal.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		passengerCarReal.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		passengerCarReal.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return passengerCarReal; 
	    }
	 private static Cabriolet parseCabriolet(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Cabriolet cabriolet = new Cabriolet();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "retractableRoof":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		cabriolet.setRetractableRoof(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		cabriolet.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		cabriolet.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return cabriolet; 
	    }
	 private static Crossover parseCrossover(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Crossover crossover = new Crossover();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "fourwheelDrive":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crossover.setFourwheelDrive(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		crossover.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		crossover.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return crossover; 
	    }
	 private static Minivan parseMinivan(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Minivan minivan = new Minivan();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "extraSeats":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		minivan.setExtraSeats(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		minivan.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		minivan.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return minivan; 
	    }
	 private static Pickup parsePickup(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Pickup pickup = new Pickup();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "cargoPlatform":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		pickup.setCargoPlatform(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		pickup.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		pickup.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return pickup; 
	    }
	 private static Electrocar parseElectrocar(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Electrocar electrocar = new Electrocar();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPassengers":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setNumberOfPassengers(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "battery":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		electrocar.setBattery(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		electrocar.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		electrocar.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return electrocar; 
	    }
	 private static STOForTrucks parseSTOForTrucks(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			STOForTrucks stoForTrucks = new STOForTrucks();
			Address address = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "name":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForTrucks.setName(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPosts":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForTrucks.setNumberOfPosts(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "heavyWeightStand":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForTrucks.setHeavyWeightStand(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "cargoLift":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForTrucks.setCargoLift(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "address":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		address = parseSTOAddress(xmlEvent, xmlEventReader);
	        		stoForTrucks.setAddress(address);	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return stoForTrucks; 
	    }
	 private static DumpTruck parseDumpTruck(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			DumpTruck dumpTruck = new DumpTruck();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "carrying":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setCarrying(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "tailBoard":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		dumpTruck.setTailBoard(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		dumpTruck.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		dumpTruck.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return dumpTruck; 
	    }
	 private static Truck parseTruck(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Truck truck = new Truck();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "carrying":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setCarrying(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "body":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		truck.setBody(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		truck.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		truck.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return truck; 
	    }
	 private static Tracktor parseTracktor(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Tracktor tracktor = new Tracktor();
			Insurance insurance = null;
			Crash crash = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "model":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setModel(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "year":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setYear(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "enginePower":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setEnginePower(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "lenght":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setLenght(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "width":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setWidth(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "costOfcar":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setCostOfCar(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "carrying":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setCarrying(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "trailer":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		tracktor.setTrailer(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "insurance":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		insurance = parseInsurance(xmlEvent, xmlEventReader);
	        		tracktor.setInsurance(insurance);
	        		xmlEvent = xmlEventReader.nextTag();
	        		
	        	}
	        	case "crash":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		crash = parseCrash(xmlEvent, xmlEventReader);
	        		tracktor.setCrash(crash);
	        		xmlEvent = xmlEventReader.nextTag();
	        }
	        }
	        return tracktor; 
	    }
	 private static Insurance parseInsurance(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Insurance insurance = new Insurance();
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "validity":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		insurance.setValidity(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "driverAge":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		insurance.setDriverAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "driverExperience":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		insurance.setDriverExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "data":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		insurance.setDate(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return insurance; 
	    }
	 private static Crash parseCrash(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  Exception {
			StartElement startElement = xmlEvent.asStartElement();
			Crash crash = new Crash();
			switch(startElement.getName().getLocalPart()) {        		
	        	case "name":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crash.setName(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "number":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crash.setNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "cost":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		crash.setCost(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return crash; 
	    }
	 private static STOForElectrocar parseSTOForElectrocar(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			STOForElectrocar stoForElectrocar = new STOForElectrocar();
			Address address = null;
	        switch(startElement.getName().getLocalPart()) {        		
	        	case "name":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForElectrocar.setName(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "numberOfPosts":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForElectrocar.setNumberOfPosts(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "highVSocket":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForElectrocar.setHighVSocket(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "newBattery":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		stoForElectrocar.setNewBattery(Integer.parseInt(xmlEvent.asCharacters().getData()));
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "address":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		address = parseSTOAddress(xmlEvent, xmlEventReader);
	        		stoForElectrocar.setAddress(address);	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return stoForElectrocar; 
	    }
		private static Address parseSTOAddress(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			Address address = new Address();
	        switch(startElement.getName().getLocalPart()) {
	        	case "country":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		address.setCountry(xmlEvent.asCharacters().getData());	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	     		}       
	        	case "city":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		address.setCity(xmlEvent.asCharacters().getData());	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}        	
	        	case "street":{
	       			xmlEvent = xmlEventReader.nextEvent();
	                address.setStreet(xmlEvent.asCharacters().getData());
	                xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	       		}       		
	       		case "house":{
	       			xmlEvent = xmlEventReader.nextEvent();
	                address.setHouse(Integer.parseInt(xmlEvent.asCharacters().getData()));	
	                xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	       		}       		
	       		      		
	        }
			return address;
		}
		private static Address parseClientAddress(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			Address address = new Address();
	        switch(startElement.getName().getLocalPart()) {
	        	case "country":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		address.setCountry(xmlEvent.asCharacters().getData());	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	     		}       
	        	case "city":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		address.setCity(xmlEvent.asCharacters().getData());	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}        	
	        	case "street":{
	       			xmlEvent = xmlEventReader.nextEvent();
	                address.setStreet(xmlEvent.asCharacters().getData());
	                xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	       		}       		
	       		case "house":{
	       			xmlEvent = xmlEventReader.nextEvent();
	                address.setHouse(Integer.parseInt(xmlEvent.asCharacters().getData()));	
	                xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	       		} 
	       		case "flat":{
	       			xmlEvent = xmlEventReader.nextEvent();
	                address.setFlat(Integer.parseInt(xmlEvent.asCharacters().getData()));	
	                xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	       		}      		
	        }
			return address;
		}
		private static Client parseClient(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
			StartElement startElement = xmlEvent.asStartElement();
			Client client = new Client();
			Address address = null;
	        switch(startElement.getName().getLocalPart()) {  
	        	case "name":{
	        		xmlEvent = xmlEventReader.nextEvent();
	        		client.setName(xmlEvent.asCharacters().getData());
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        	case "address":{
	        		xmlEvent = xmlEventReader.nextTag();
	        		address = parseClientAddress(xmlEvent, xmlEventReader);
	        		client.setAddress(address);	
	        		xmlEvent = xmlEventReader.nextTag();
	        		xmlEvent = xmlEventReader.nextTag();
	        	}
	        }
	        return client; 
	    }
	 public static void main(String[] args) throws Exception {
			parseXML("C:\\Users\\Asus\\eclipse-workspace\\Car\\src\\main\\resources\\new 2.xml");	
			}
}

