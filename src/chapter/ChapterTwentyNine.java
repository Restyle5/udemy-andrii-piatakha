package chapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import annotation.Test;

public class ChapterTwentyNine implements Chapter{
	private Note notes;
	
	public ChapterTwentyNine() {
		Note notes = new ChapterNote(Arrays.asList("Java Reflection API"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {
		return "Java Reflection API & Annotation";
	}

	@Override
	public List<String> getNotes() {
		return this.getNotes();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		topicJavaReflection();
		try{ topicAnnotation(); } catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void topicJavaReflection() {
		Class<?> user2 = new User().getClass();
		
		System.out.println(user2.getName());
		Field[] fields = user2.getDeclaredFields();
		
		Arrays.stream(fields).forEach(f -> System.out.println(f));
		Arrays.stream(fields).forEach(f -> System.out.println(f.getType()));
		
		
//		User user = new User();
//		System.out.println("result: " + user.getClass());
		
	}
	
	public static void topicAnnotation() throws Exception {

	    ChapterTwentyNine obj = new ChapterTwentyNine();

	    Method method =
	        ChapterTwentyNine.class.getDeclaredMethod(
	            "topicAnnotationSample");

	    Test test = method.getAnnotation(Test.class);

	    Class<? extends Throwable> expected =
	        test.expected();

	    try {

	        method.invoke(obj);

	        if (expected == Test.None.class) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL - expected exception");
	        }

	    } catch (Exception e) {

	        Throwable actual = e.getCause();

	        if (expected.isInstance(actual)) {
	            System.out.println("PASS");
	        } else {
	            System.out.println(
	                "FAIL - expected " +
	                expected.getSimpleName() +
	                ", got " +
	                actual.getClass().getSimpleName()
	            );	
	        }
	    }
	}
	
	
	@Test(name = "Division by zero should fail", expected = ArithmeticException.class)
	public void topicAnnotationSample() {
		int x = 1 / 0;
	}
}


final class User {
	
	private String name = "";
	private String age;
	private static int leg = 2;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}