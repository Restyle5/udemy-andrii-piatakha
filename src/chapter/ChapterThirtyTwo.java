package chapter;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChapterThirtyTwo implements Chapter{

	private Note notes;
	
	public ChapterThirtyTwo() {
		ChapterNote notes = new ChapterNote(Arrays.asList("Localization and Internationalization"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {
		return "I18N & L10N";
	}

	@Override
	public List<String> getNotes() {
		return notes.getNotes();
	}

	@Override
	public void execute() {
		topicLocalizationAndInternationalization();
		topicResourceBundles();
	}
	
	
	public void topicLocalizationAndInternationalization() {
		Locale l1 = new Locale("hi", "IN");
		Locale l2  = new Locale("en", "US");
		
		
		//		Locale.setDefault(l1);
		System.out.println(Locale.getDefault());
		
//		printAllAvaiableLocales();
		PrintDoubleValues(13322424.81d);
	}
	
	public void topicResourceBundles() {
		ResourceBundle myBundle = ResourceBundle.getBundle("MyLabels", new Locale("ru", "RU"));
		

		Locale.setDefault(new Locale("ru", "RU"));
		
		
		System.out.println("\"Welcome\" in Russian:\t" 
								+ myBundle.getString("welcome.message"));
		System.out.println("\"Login Button Text\" in Russian:\t" 
				+ myBundle.getString("login.button.text"));
		
		
		
		
//		System.out.println(myBundle.getString("welcome.message"));
	}
	
	private void printAllAvaiableLocales()
	{
		for(Locale local: DateFormat.getAvailableLocales()) {
			System.out.println(local);
		}
	}
	
	private void PrintDoubleValues(double values)
	{	
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		System.out.println("US : " + nf.format(values));
		
		nf = NumberFormat.getInstance(new Locale("ru", "RU"));
		System.out.println("Russia : " + nf.format(values));
		
		nf = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println("GERMANY : " + nf.format(values));
		
		System.out.println("Money in USA:\t\t" + NumberFormat.getCurrencyInstance(Locale.US).format(values));
		System.out.println("Money in Germany:\t" + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(values));
		System.out.println("Money in Russia:\t" + NumberFormat.getCurrencyInstance(new Locale("ru", "RU")).format(values));
		System.out.println("Money in India:\t\t" + NumberFormat.getCurrencyInstance(new Locale("hi", "IN")).format(values));
		System.out.println("Money in UK:\t\t" + NumberFormat.getCurrencyInstance(Locale.UK).format(values));
		
	    ZonedDateTime zoned = ZonedDateTime.now();
	    
	    DateTimeFormatter pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
	    System.out.println("Date in USA:\t\t" + zoned.format(pattern));
	    
	    pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMANY);
	    System.out.println("Date in Germany:\t" + zoned.format(pattern));
	    
	    pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("ru", "RU"));
	    System.out.println("Date in Russia:\t\t" + zoned.format(pattern));
		
	}
}
