package chapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
//		topicCalendar();
		topicInstant();
		topicLocalDateTime();
		
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
	
	public static void topicInstant()
	{
		System.out.println("=== Instant class ===");
		Instant instant1 = Instant.now();
		System.out.println("Instant_now: " + instant1.toString());
		
		Instant instant2 = Instant.now(Clock.systemUTC());
		
		System.out.println("With Parameter: Clock.SystemUTC(): " + instant2);
		System.out.println(instant1.plusNanos(12242424));
		System.out.println(instant1.minusSeconds(120));
		System.out.println(instant1.plus(2, ChronoUnit.DAYS));
		System.out.println(instant1.minus(1, ChronoUnit.HOURS));
		
		
		System.out.print(instant1.isBefore(instant2));
		System.out.println("\n" + instant2.isBefore(instant1));
		System.out.println(instant1.compareTo(instant2));
	}
	
	public static void topicLocalDateTime()
	{
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println("LocalDateTime: " + ldt.toString());
		System.out.println(ldt.plusDays(4).toString());
		System.out.println(ldt.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
	}

}
