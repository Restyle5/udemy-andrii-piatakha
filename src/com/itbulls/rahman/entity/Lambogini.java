package com.itbulls.rahman.entity;

import interfaces.CarChargerInterface;

public class Lambogini extends Car implements CarChargerInterface{

	@Override
	protected void getModel() {
		// TODO Auto-generated method stub
		System.out.println("b134");
		
		
	}
	
	public void getLamboModel(){
		this.getModel();
	}

	@Override
	public void getProvider() {
		System.out.print("The provider is LAMBO.co");
		
	}
	
}
