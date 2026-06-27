package chapter;


import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ChapterThirtyFour implements Chapter{

	private Note notes;
	
	private static final Logger logger = LogManager.getLogger(ChapterThirtyFour.class);
	
	public ChapterThirtyFour() {
		ChapterNote notes = new ChapterNote(Arrays.asList("Loggin in Java"));
		this.notes = notes;
	}

	@Override
	public String getChapterName() {
		return "Loggin in Java";
	}

	@Override
	public List<String> getNotes() {
		return notes.getNotes();
	}

	@Override
	public void execute() {
		topicJavaLogginFramework();
		topicLog4J();
	}

	public static void topicJavaLogginFramework() {
		// TODO: Implement Java Logging	
		System.out.println("After maven");
		
	}
	
	public static void topicLog4J()
	{
		 for (int i = 1; i <= 200; i++) {

	            logger.info(
	                "Message {} - Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
	                i
	            );

	        }

	        System.out.println("Done!");
	}
	
}