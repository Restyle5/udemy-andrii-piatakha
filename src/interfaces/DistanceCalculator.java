package interfaces;

import com.itbulls.rahman.entity.City;

@FunctionalInterface
public interface DistanceCalculator {
	
	double calculateDistance(City city1, City city2);
	
	default void someDefaultMethod() {}
	
	static void someStaticMethod() {}
}
