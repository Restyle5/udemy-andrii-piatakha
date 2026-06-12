package chapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itbulls.rahman.entity.Employee;

public class ChapterTwentyFour implements Chapter {

	private Note note;
	
	public ChapterTwentyFour() {
		Note notes = new ChapterNote(Arrays.asList("Input/Output Stream"));
		this.note = notes;
		
	}
		
	@Override
	public String getChapterName() {
		return "Input and Output Stream in Java";
	}

	@Override
	public List<String> getNotes() {
		return this.note.getNotes();
	}

	@Override
	public void execute() {
		
		//serialization and cloning:
		ChapterTwentyFour.serializationAndCloningTopic();
		
		// Topic: IO Stream in Java
		System.out.println("--- executing Chapter 24 ---");
		
		File file = new File("testDirectory");
		File file2 = new File("testDirectory2//sample");
		
		System.out.println(file2.mkdirs());
		
		if(file.mkdir()) {
			System.out.println("success");
		}else {
			System.out.println("Files are Exist");
		}
		
		String toWrite = "asd " + System.lineSeparator() + "new line";
		
		
		try {
			
			file2 = new File("result.csv");
			file2.createNewFile();
			file2.exists();
			
			if(file2.isDirectory()) {
				File[] files = file2.listFiles();
			}
			System.out.println("absolute path: " + file2.getAbsolutePath());
		
		}catch(Exception e) {
			System.out.println("exception: " + e);
		}
		
	}
	
	public static final void serializationAndCloningTopic() {
		System.out.println("--- executing serialization topics. ---");
		
		Employee empl = new Employee();
		empl.setId(1);
		empl.setName("Ofzhiar");
		
		Map<String, String> props = new HashMap<>();
		props.put("salary", "5000");
		props.put("City", "Shah Alam");
		
		empl.setProps(props);
		
		var byteArrayOutputStream = serializeEmployee(empl);
		Employee copyEmployee = deserializeEmployee(byteArrayOutputStream);
		
		System.out.println(copyEmployee);
		
		try {
			Employee empClone = (Employee) empl.clone();
			System.out.println("The clone: " + empClone);
			
			empl.setId(2);
			System.out.println("True record after clone, and after modification: " + empl);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	private static ByteArrayOutputStream serializeEmployee(Employee empl)
	{
		try( var byteArrayOutputStream = new ByteArrayOutputStream(); var oos = new ObjectOutputStream(byteArrayOutputStream))
		{
			oos.writeObject(empl);
			return byteArrayOutputStream;
			
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Employee deserializeEmployee(ByteArrayOutputStream inputStream) {
		try(var ois = new ObjectInputStream(new ByteArrayInputStream(inputStream.toByteArray()))){
			return (Employee) ois.readObject();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
