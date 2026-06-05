package com.itbulls.rahman;

import com.itbulls.rahman.entity.Lambogini;

import interfaces.CarChargerInterface;

public class SectionThirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Anonymous class 
		Product product = new Product() {
			@Override
			String getVoice() {
				// TODO Auto-generated method stub
				return "new voice";
			}
		};
		
//		Car car = new Car(){
//
//			@Override
//			protected void getModel() {
//				// TODO: add something 
//			}
//		};
		
		Lambogini car2 = new Lambogini();
		
		
		System.out.println(getSomething(car2));
	
		System.out.println(product.getVoice());
		car2.getLamboModel();

	}
	
	public static String getSomething(CarChargerInterface c)
	{
		return "working ...";
	}
}
