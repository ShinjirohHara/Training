
public class NaNTest {
	
	public static void main(String args[]) {
		
		System.out.println(Float.POSITIVE_INFINITY + " + " + Float.POSITIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY+Float.POSITIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " - " + Float.POSITIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY-Float.POSITIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " * " + Float.POSITIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY*Float.POSITIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " / " + Float.POSITIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY/Float.POSITIVE_INFINITY));
		
		System.out.println(Float.POSITIVE_INFINITY + " + " + Float.NEGATIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY+Float.NEGATIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " - " + Float.NEGATIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY-Float.NEGATIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " * " + Float.NEGATIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY*Float.NEGATIVE_INFINITY));
		System.out.println(Float.POSITIVE_INFINITY + " / " + Float.NEGATIVE_INFINITY + " = " + (Float.POSITIVE_INFINITY/Float.NEGATIVE_INFINITY));
		
	}

}
