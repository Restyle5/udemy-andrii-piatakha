package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//meta annotation

// 1. Target provides context in which	an annotation type is applicable.	 
@Target(ElementType.METHOD)
// 2. Defined how long does this annotation retained, 
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	Class<? extends Throwable> expected() default None.class;
	
	String name() default "";
	
	static class None extends Throwable{
		private None() {}
	}
}
