package chapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class ChapterTwentyEight implements Chapter{

	private Note notes;
	
	public ChapterTwentyEight() {
		ChapterNote notes = new ChapterNote(Arrays.asList("GMT, UTC", "Calendar", "SimpleDateFormat"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {
		
		return "Date and Time in JDK";
	}

	@Override
	public List<String> getNotes() {
		
		return notes.getNotes();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		topicCalendar();
		
	}
	
	public static void topicCalendar() {
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println("Day_of_month: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Month: " + calendar.get(Calendar.MONTH));
		System.out.println("Year: " + calendar.get(Calendar.YEAR));
		System.out.println("Hour (12): " + calendar.get(Calendar.HOUR));
		System.out.println("Hour_of_day (24): " + calendar.get(Calendar.HOUR_OF_DAY));

		// ======== SimpleDateFormat =========
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		System.out.println("SimpleDateFormat: "	+ sdf.format(calendar.getTime()));

		// ======== Date instance =========
		try {
		Date d = new Date();
		Date dateParsed = sdf.parse("10/01/1999 10:02:02 PM");
		
		System.out.println("Sdf Parsed into Date: " + dateParsed.toString());
		System.out.println("Date Instance: " + d.toString() );
		}catch(ParseException e) {
			e.printStackTrace();	
		}
		
	}

}
