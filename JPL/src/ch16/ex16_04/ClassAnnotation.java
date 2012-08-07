package ch16.ex16_04;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface ClassInfo {
	String created();
	String createdBy();
	String lastModified();
	String lastModifiedBy();
	int revision();
}

@ClassInfo (created = "2012/07/28", createdBy = "Shinjiroh Hara", lastModified = "2012/07/28", lastModifiedBy = "Shinjiroh Hara", revision = 0)
public class ClassAnnotation {
	public static void main (String[] args) {
		if (args.length < 1) {
			throw new IllegalArgumentException("too few parameter");
		}
		
		Class<?> cls;
		try {
			cls = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println(cls);
		Annotation[] annotations = cls.getDeclaredAnnotations();
		for (Annotation elem : annotations)
			System.out.println(elem);
	}
}
