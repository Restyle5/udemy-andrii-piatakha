package com.itbulls.rahman;

import java.util.Arrays;
import java.util.Scanner;

public class ReadFromConsole {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Write your name: ");
		String name = sc.next();
		System.out.println("Your name is: " + name);
		System.out.print("Enter a number: ");
		int i = sc.nextInt();
		System.out.println("You entered: " + i);

//		Parsing number, sum, and add output
//		System.out.println(Arrays.toString(args));
//		
//		int i = Integer.parseInt(args[0]);
//		int i2 = Integer.parseInt(args[1]);
//		
//		System.out.println( i + i2);
	}
}
