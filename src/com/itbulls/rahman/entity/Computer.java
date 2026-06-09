package com.itbulls.rahman.entity;

public class Computer {
	
	public Computer(){}

	protected String cpu(){
		return "i5 10th gen";
	}
	
	public static void repair(String name) {
		System.out.println("Overload: String-param");
	}
	
	public static void repair() {
		System.out.print("default");
	}
	
	public void repair(int caps){
		System.out.println("Overload: Int-param");
	}
	
	String ram(){
		return "1.2gb";
	};
}
