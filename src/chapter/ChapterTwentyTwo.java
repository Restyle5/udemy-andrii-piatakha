package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.itbulls.rahman.entity.City;

public class ChapterTwentyTwo implements Chapter {

	private Note note;

	public ChapterTwentyTwo() {
		List<String> notes = new ArrayList<>(Arrays.asList("Stream API"));
		this.note = new ChapterNote(notes);
	}

	@Override
	public String getChapterName() {
		return "Stream API";
	}

	@Override
	public List<String> getNotes() {

		return this.note.getNotes();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		Set<City> cities = new HashSet<>();
		
		cities.add(new City());
		cities.add(new City());
		cities.add(new City());
		
		Random random = new Random();
		cities.forEach(c -> c.setLatitude(random.nextDouble()));
		
		// remove numbers below .4
		List<City> newCities = cities.stream().filter(c -> {
			System.out.println("c :"+  c.getLatitude());
			return c.getLatitude() > .4d;
		}).map(c -> {
			
			// add (1) for every remaining component.
			c.setLatitude(c.getLatitude() + 1);
			
			return c;
		}).collect(Collectors.toList());
		
		newCities.forEach( c -> System.out.println(c.getLatitude()));
		
		
		String[] names = new String[] {"Perci", "ken"};
		
		Stream<String> nameStream = Stream.of(names);
		
		String[] describedNames = nameStream.map(n -> "Name: " + n).toArray(String[]::new);
		
		for(String name: describedNames) {
			System.out.println(name);
		}

	}

}
