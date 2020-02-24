package com.log4j.example;

import java.io.*;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * log4j demo
 *
 */
public class interestcalculation 
{
	double p,r,t;

	void takeInput() {

		Scanner sc = new Scanner(System.in);
		p = sc.nextDouble();
		r = sc.nextDouble();
		t = sc.nextDouble();
		sc.close();
		if(p<0 || r<0 || t<0 ) {
			throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
		}
	}

	// compute the simple interest and return the value.

		double SIcalculate() {
				double si = p*r*t/100;
				return si;
		}

		double CIcalculate() {
			double ci = p*(Math.pow((1+r/100),t))-p;
			return ci;
		}




	private static final Logger log = LogManager.getLogger(interestcalculation.class);
	public static void main( String	[] args ) throws IOException
	{
		BasicConfigurator.configure();     
		//		log.info("this is info!");
		//		log.debug("hey");
		//		log.error("hello!");
		//		log.fatal("you got fatal");	

		interestcalculation obj = new interestcalculation();	
		obj.takeInput();
		try {
			log.info("simple interest: "+obj.SIcalculate());
			log.info("compund interest: "+obj.CIcalculate());
		}catch(ArithmeticException e) {
			log.error("oops! something wents wrong!");
		}
		
	}
}
