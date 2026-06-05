package chapter;

import java.util.List;

public interface Chapter {
	
	 abstract String getChapterName();
	 
	 abstract List<String> getNotes();
	 
	 abstract void execute();
	 
	 default String getChapterVersion() {
		 return  "17";
	 }
}
