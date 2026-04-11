package com.itbulls.rahman;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ControlStatement {

	public static void main(String[] args) {

		
//		List<String> list = Arrays.asList(args);
//		
//		boolean isAdmin = list.contains("--admin");
//		boolean isGuest = list.contains("--guest");
//		
//		
//		if(isAdmin && isGuest)
//		{
//			System.out.println("Please, select either 'ADMIN' or 'GUEST' mode for this program");
//		}else if(isAdmin) 
//		{
//			System.out.println("Hello, Admin!");
//		}else if(isGuest)
//		{
//			System.out.println("Hello, Guest!");
//		}
		
		
//      // Second Exercise.
//		if(args.length < 2 )
//        {
//            System.out.println("not enough arguments");
//        }else{
//            
//            BigDecimal a = new BigDecimal(args[0]);
//            BigDecimal b = new BigDecimal(args[1]);
//            
//            System.out.println(a.add(b));
//        }
		
//		char a = 'B';
//		
//		switch(a) {
//		case 'A':
//			System.out.println("This is most defenetly A");
//		break;
//		
//		case 'B', 'C':
//			System.out.println("Its either B OR C, but right now, it is: " + a);
//		break;
//		
//		default: 
//			System.out.println("uknown");
//		}
		
		
        int min = 205;
        int max = 369;

        int randomNumber = (int)(Math.random() * (max - min + 1)) + min;

        System.out.println("Random number: " + randomNumber);
		

	}
}
