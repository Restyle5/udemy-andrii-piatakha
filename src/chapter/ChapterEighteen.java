package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SequencedMap;
import java.util.TreeMap;

public class ChapterEighteen implements Chapter{
	
	private final Note note;
	
	public ChapterEighteen(){
		List<String> noteList = new ArrayList<>(Arrays.asList("Interfaces List, Set and Queue: Overview"));
		this.note = new ChapterNote(noteList);
	}

	@Override
	public String getChapterName() {
		return "Java Collection Frameworks (JCF)";
	}

	@Override
	public List<String> getNotes() {
		// TODO Auto-generated method stub
		return note.getNotes();
	}

	@Override
	public void execute() {
		
		System.out.println("Executing Chapter: 18");
		
		List list1 = new ArrayList();
		// generic list allows sepeficified type to be in the list.
		List<String> genericList = new ArrayList<>();
		
		list1.add("Aldebaran");
		genericList.add("Breeze");
		
		list1.add(1); // this is allowed in no generic list
		
		List<Integer> listNumber = new ArrayList<>(Arrays.asList(1,2,3));
		Iterator<Integer> iterator = listNumber.iterator();
		ListIterator<Integer> reverseIterator = listNumber.listIterator();
		
		while(reverseIterator.hasNext()) {
			System.out.println("Number: " +reverseIterator.next());
		}
		
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		if(!iterator.hasNext()) {
			System.out.println("It is no longer containing NEXT");
		}
		
		iterator = listNumber.iterator();
		
		
		if(!iterator.hasNext()) {
			System.out.println("It is no longer containing NEXT");
		}else {
			if(iterator.hasNext()) 
			{ 
			System.out.println(iterator.next());
			}else {
				System.out.println("You should no be seeing this because next only called once and the number of the elements are 3");
			}
		}
		
		NavigableMap<Integer, String> treeMap = new TreeMap<>();
		
		treeMap.put(1, "lebron");
		treeMap.put(4, "Jakes");
		treeMap.put(6, "Ali");
		treeMap.put(9, "Dale");
		treeMap.put(2, "Son");
		
		SequencedMap<Integer, String> sMap = new LinkedHashMap<>();
		sMap.putFirst(1, "Vale");
		sMap.putLast(2, "Dale");
		
		
		SequencedMap<Integer, String> reversed = sMap.reversed();
		
		System.out.println("reversedMap: " + reversed);
		
		System.out.println( "First Entry" + treeMap.firstEntry());
		
		Map<Integer, String> names = new HashMap<>();
		names.put(1, "arac");
		names.put(2, "barac");
		names.put(3, "carac");
		
		
		List<Entry<Integer, String>> nameList = new ArrayList<>(names.entrySet());
		Collections.shuffle(nameList);
		
		System.out.println("after shuffles: " + nameList);
		nameList.sort(Entry.comparingByKey());
		
		System.out.println("sorted by key: " + nameList);
		
		System.out.println(list1);
		System.out.println(genericList);
		

	}



}
