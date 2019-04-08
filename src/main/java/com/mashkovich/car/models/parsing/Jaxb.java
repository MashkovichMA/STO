package com.mashkovich.car.models.parsing;
import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.mashkovich.car.models.parsing.STOProject;
import com.mashkovich.car.models.sto.Runner;

public class Jaxb {
	private static final Logger log = Logger.getLogger(Runner.class);
	public static void main(String[] args) throws JAXBException, FileNotFoundException  {
		File fileName = new File ("C:\\Users\\Asus\\eclipse-workspace\\Car\\src\\main\\resources\\new 2.xml");
		parseJaxb(fileName);
	}
	private static void parseJaxb(File fileName) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(STOProject.class);
		Unmarshaller m = context.createUnmarshaller();
		STOProject stoProject = (STOProject) m.unmarshal(fileName);
		log.info(stoProject);	
	}
}


