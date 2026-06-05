package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		

	}



}
