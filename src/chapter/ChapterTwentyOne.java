package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.itbulls.rahman.entity.City;

import interfaces.DistanceCalculator;

public class ChapterTwentyOne implements Chapter{

	private Note note;
	
	public ChapterTwentyOne() {
		
		List<String> list = new LinkedList<>();
		list.add("Overview");
		list.add("Interfaces,  Lambda Function and Method.");
		this.note = new ChapterNote(list);
	}
	
	@Override
	public String getChapterName() {
		return "Functional Programming in Java";
	}

	@Override
	public List<String> getNotes() {
		
		return this.note.getNotes();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
			
		DistanceCalculator dCalculator =  (city1, city2) -> city1.getLongitude() - city2.getLongitude();
		DistanceCalculator dCalculator2 =  (city1, city2) -> {
			return city1.getLongitude() - city2.getLongitude();
		};
		
		City c1 = new City(); 
		City c2 = new City();
		
		c1.setLatitude(3.1d);
		c1.setLongitude(101.41d);
		
		c2.setLatitude(3.2d);
		c2.setLongitude(104.41d);
		
		double result = dCalculator2.calculateDistance(c2, c1);

		ChapterTwentyOneSample ObDistance = new ChapterTwentyOneSample();
		// First Formula
		ObDistance.setDistanceCalculatorFormula((city1, city2) -> { 
			return city1.getLongitude() - city2.getLongitude();
			}
		);
		
		double newDistance = ObDistance.calculateDistance(c1, c2);
		System.out.println("New Distance is: " + newDistance);

		// Second Formula
		ObDistance.setDistanceCalculatorFormula(GoogleDistanceCalculator::getDistanceBetweenCitiesStatic);
		double newDistanceByGoogle = ObDistance.calculateDistance(c1, c2);
		
		System.out.println("New Distance by Google is: " + newDistanceByGoogle);
			
		
		Function<String, Integer> length = s -> s.length();
		Function<Integer, Integer> doubleIt = s -> s * 2 ;
		Function<String, Integer> combined = length.andThen(doubleIt);
		Function<String, Integer> composed = combined.compose(s -> s + "abcde");
		
		List<String> names = new ArrayList<>(Arrays.asList("Diablo", "Es Diandra", "Normad"));

		
		Consumer<String> nameCheck = s -> {
			if(s.length() < 7) {
				System.out.println("Printing names while length is less than 7: ");
				System.out.println(s);
			}
		};
		
		BiPredicate<String, Integer> charLimit = (s, i) -> {
			return  s.length() > i;
		};
		
		Integer limit = 6;
		
		System.out.println("IS this name over the limit ?" + names.get(0) + ", The limit is : " + limit  + ", and it is " +   charLimit.test(names.get(0), limit) );
		 
		names.iterator().forEachRemaining(nameCheck);
		
		
		System.out.println(getChapterName() + " is about : " + length.apply(getChapterName()));
		System.out.println("combined functions (andThen): " + combined.apply(getChapterName()));
		System.out.println("composed but with combined: (add more strings) -> (calc length) -> times 2: " + composed.apply(getChapterName()));
		System.out.println(result);
	}

}

class ChapterTwentyOneSample
{
	DistanceCalculator distanceCalculator;
	
	void setDistanceCalculatorFormula(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}
	
	double calculateDistance(City city, City city2)
	{
		return this.distanceCalculator.calculateDistance(city, city2);
	}
}

class GoogleDistanceCalculator{
	public static double getDistanceBetweenCitiesStatic(City city1, City city2) 
	{
		return city1.getLatitude() - city2.getLatitude();
	}
}
