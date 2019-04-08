package com.mashkovich.car.models.parsing;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Jackson {

	private static final Logger log = Logger.getLogger(Jackson.class);
	public static void main (String [] args) {
		parse("C:\\Users\\Asus\\eclipse-workspace\\Car\\src\\main\\resources\\STO.json");
	}
    private static void parse (String file) {
    	ObjectMapper mapper = new ObjectMapper();
    	try { 
    		STOProject stoProject = mapper.readValue(new File(file), STOProject.class);
            log.info(stoProject);
    	}catch (JsonParseException e) {
    		e.printStackTrace();
    	}catch (JsonMappingException e) {
    		e.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}

