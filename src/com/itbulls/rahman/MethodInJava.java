package com.itbulls.rahman;

import java.util.Arrays;

import enumerations.Priority;

public class MethodInJava {

	public static void main(String[] args) {
		System.out.println(calcFactorial(5));
		System.out.println(getGreatestCommonDivisor(48, 18));
		
		Priority priority = Priority.HIGH;
		
		System.out.println(priority);
		System.out.println(priority.getPrioIndex());
		System.out.println(Arrays.toString(Priority.values()));
		

	}
	
	private static int calcFactorial(int number) {
		
		
		if(number > 1)
		{
			return number * calcFactorial(number - 1);
		}else {
			return 1;
		}
	}
	
	// using Euclidean Algorithm a b a&b, move to left.
	private static int getGreatestCommonDivisor(int a, int b) {
		
		while(b != 0)
		{
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

	
}
