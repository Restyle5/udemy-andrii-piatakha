package chapter;

import java.util.List;

public class ChapterNote implements Note{
	private List<String> list;
	
	public ChapterNote(List<String> list){
		this.setNotes(list);
	}
	
	@Override
	public void setNotes(List<String> list) {
		this.list = list;
		
	}

	@Override
	public List<String> getNotes() {
		return list;
	}

}
