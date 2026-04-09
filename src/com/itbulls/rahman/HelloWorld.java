package com.itbulls.rahman;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Hello world .
 * 
 * @author restyle5
 * 
 */
public class HelloWorld {

	/**
	 * Default constructor for HelloWorld.
	 */
	public HelloWorld() {
		// no initialization needed
	}

	/**
	 * The entry point to the program
	 * 
	 * @param args input string
	 */
	public static void main(String[] args) {
		/**
		 * Please, do not remove this code.
		 */

		BigDecimal taxiFee = BigDecimal.valueOf(20).setScale(2);
		BigDecimal person = BigDecimal.valueOf(3);
		BigDecimal chargeFeesPerPerson2 = taxiFee.divide(person, RoundingMode.HALF_UP);
		BigDecimal chargeFeesPerPerson = taxiFee.divide(person, RoundingMode.CEILING);
		
		System.out.println(taxiFee);
		System.out.println(chargeFeesPerPerson2);
		System.out.println(chargeFeesPerPerson);
		
		BigDecimal person4 = BigDecimal.valueOf(3.1);
		BigDecimal person5 = BigDecimal.valueOf(1.21);
		
		double a = 3.1;
		double b = 1.21;
		BigDecimal person6 = BigDecimal.valueOf(a - b).setScale(2, RoundingMode.HALF_UP);
		
		System.out.println(person4.subtract(person5));
		System.out.println(person6);
		// TODO add more code here in the future.
	}

}
