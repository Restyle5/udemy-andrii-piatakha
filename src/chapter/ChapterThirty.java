package chapter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import com.itbulls.rahman.entity.MySubscriber;

public class ChapterThirty implements Chapter{

	private Note notes;
	
	public ChapterThirty() {
		Note notes = new ChapterNote(Arrays.asList("String Builder & String Buffer", "Optional", "Reactive Programming (FlowAPI, Reactive stream)"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {
		return "JDK API";
	}

	@Override
	public List<String> getNotes() {
		return notes.getNotes();
	}

	@Override
	public void execute() {
		topicStringBuilderAndBuffer();
		topicOptional();
		topicReactiveProgramming();
	}	
	
	public static void topicStringBuilderAndBuffer() {
		
		
		// String is immutable, therefore any changes creates new Object in Heap Memory. SB Only created one of its self.
		StringBuilder sb = new StringBuilder("B13FC: ");
		sb.append("DD13F").append(": LQWE4");
		
		// Mostly Similar to String Builder in term of naming/functionality, but String-Buff is thread-safe;
		StringBuffer sbuff = new StringBuffer("First, ");
		sbuff.append(sb);
		
		
		System.out.println(sb.append( " > " + sb.length()));
		System.out.println(sbuff);
	}
	public static void topicOptional() {
		var computer = new Computer();
		USBDrive usb1 = new USBDrive();
		
//		computer.setUSBDrive(usb1);
		
		computer.getUsbDrive().ifPresentOrElse(e -> {
			System.out.println("It is Not null, The version number is: " + e.VERSION);
		}, ()->{
			System.out.println("It is not here.");
		});
		
		Optional<String> test = Optional.of("Alen Walker");
		
		String filteredName = test.filter(name -> name.contains("ker")).orElse("Name not found ");
		System.out.println(filteredName);
	}
	
	public static void topicReactiveProgramming() {	
	
	try {
	SubmissionPublisher<Integer> publisher 	= new SubmissionPublisher<>();
		// Create a custom Processor
		MySubscriber subscriber = new MySubscriber();

        // Subscribe the Subscriber to the Publisher
        publisher.subscribe(subscriber);
        
        TimeUnit.SECONDS.sleep(1);
        // Publish some items to the Publisher
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("Publisher: Emitting item " + i);
            publisher.submit(i);
        }
        
        // Close the publisher to signal completion
        publisher.close();
        
     // Wait for subscriber to finish
        TimeUnit.SECONDS.sleep(5);
        
	}catch(Exception e) { e.printStackTrace();}
	}

}

class Computer{
	private USBDrive usbDrive;
	
	public Optional<USBDrive> getUsbDrive(){
		return Optional.ofNullable(usbDrive);
	}
	
	public void setUSBDrive(USBDrive usb)
	{
		usbDrive = usb;
	}
}

class USBDrive{
	// example.
	public int VERSION = 1;
}

