package com.itbulls.rahman.entity;

import interfaces.CarChargerInterface;

public class Perodua extends Car implements CarChargerInterface{

	private String model;
	
	public Perodua(String model){
		this.setModel(model);
	}
	
	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
		
	}

	@Override
	public String getProvider() {
		return "Tusk";
		
	}

}
