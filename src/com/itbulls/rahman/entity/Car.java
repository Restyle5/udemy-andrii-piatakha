package com.itbulls.rahman.entity;

public abstract class Car {

	public  abstract String getModel();
	
	public abstract void setModel(String model);
	
	public Car(){
		System.out.println("initializing a car");
	}
	
	String getHealth() {
		return "I'm fully charged.";
	}
	
	protected String gethealthCheck(){
		return "Engine's ready";
	}
}
