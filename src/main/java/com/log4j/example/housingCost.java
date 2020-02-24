package com.log4j.example;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class housingCost {

	int choice1, choice2;
	double area , price;

	housingCost(double area){
		this.area = area;
	}

	double standard() {
		//cost=1200 per square feet
		price = area*1200;
		return price;
	}

	double abv_standard() {
		//cost=1500 per square feet
		price = area*1500;
		return price;
	}

	double high_standard() throws IOException {
		Scanner sc = new Scanner(System.in);

		log.info("want fully automated or not(y/n):");
		char ch = sc.next().charAt(0);
		sc.close();

		if(ch == 'y') {
			//cost=2500
			price = area*2500;
		}
		else {
			//cost=1800
			price = area*1800;
		}

		return price;
	}



	private static final Logger log = LogManager.getLogger(interestcalculation.class);
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BasicConfigurator.configure();

		log.info("enter your material choice:\n1:standard material\n2:above standard material\n3:high standard material\n");
		int ch = sc.nextInt();

		log.info("enter area of the house:");
		double area = sc.nextDouble();
		sc.close();
		if(area<0) {
			throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");

		}



		housingCost obj = new housingCost(area);
		if(ch==1) {
			log.info("price of the house:" + obj.standard());
		}

		else if(ch==2) {
			log.info("price of the house:" + obj.abv_standard());
		}
		else if(ch==3){
			log.info("price of the house:" + obj.high_standard());
		}

		else {
			log.error("ERROR");
		}
	}
}
