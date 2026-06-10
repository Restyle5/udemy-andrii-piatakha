package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itbulls.rahman.entity.Car;
import com.itbulls.rahman.entity.Lambogini;
import com.itbulls.rahman.entity.Perodua;

public class ChapterNineteenth implements Chapter{
	
	private final Note note;
	
	public ChapterNineteenth()
	{
		List<String> cNote = new ArrayList<>(Arrays.asList("Generics In Java"));
		this.note = new ChapterNote(cNote);
	}
	
	@Override
	public String getChapterName() {
		return "Generics";
	}

	@Override
	public List<String> getNotes() {
		return note.getNotes();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("--------- executing section 19------------------");
		
		
		String[] e = new String[3];
		
		e[0] = "asd";
		e[1] = "efg";
		e[2] = "hij";
		
		String[] names = new String[] {"ali", "brad", "cilvia" , "darl"};
		
		ChapterNineteenth.printArray(e);
		
		List<String> listName = new ArrayList<>(Arrays.asList(names));
		names = listName.reversed().toArray(String[]::new);
		
//		ChapterNineteenth.printArray(listName.reversed().toArray());
		Car car1 = new Lambogini();
		Car car2 = new Perodua("Myvi");
		
		ChapterNineteenth.getCarInfo(car2);
	}
	
	private static <T> void printArray(T[] arr) 
	{
		for(T e: arr) {
			System.out.println(e);
		}
	}
	
	private static <T extends Car> void getCarInfo(T car) {
		System.out.println(car.getModel());
	}

}
