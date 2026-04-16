package com.itbulls.rahman;

import java.util.Random;

public class IterationStatement {
	public static void main(String args[]) 
	{
		Random r = new Random();
		
		// The purpose is only for testing label e.g. loop1 and loop2
		loop1: for(int i = 0; i < 3 ; i ++) {
			loop2: for(int j = 0; j < 6; j++) {
				
				int rndNum = r.nextInt(10) + 1;
				
				System.out.print("J is " + j + " randomed number is " + rndNum + "\n");
				if(rndNum < j) {
					continue loop2;
				}else {
					System.out.println("cond");
				}
				
				if(j == 5)
				{
					System.out.println("close by force");
					break loop1;
				}
			}
		}
	}
}
