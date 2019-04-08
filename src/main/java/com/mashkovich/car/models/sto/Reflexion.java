package com.mashkovich.car.models.sto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.mashkovich.car.models.parsing.Jackson;

public class Reflexion {
	private static final Logger log = Logger.getLogger(Reflexion.class);
	public static void main (String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException  {
		Class<?> c = Class.forName("com.mashkovich.car.models.Insurance");
		Field [] fields = c.getDeclaredFields();
		log.info(fields[1].getName() +" "+ fields[1].getType()+" " + fields[1].getModifiers() );
		Method [] methods = c.getDeclaredMethods();
			log.info(methods[3].getName()+" " + methods[3].getReturnType()+" "+methods[3].getModifiers()+" "+methods[3].getParameters()[0].getName());
		}
}

