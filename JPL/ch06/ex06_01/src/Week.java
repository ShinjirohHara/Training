
public class Week {

	enum Type {
		MONDAY, TUESDAY, WEDNESDAY, THURTHAY, FRIDAY, SATURDAY, SUNDAY 
	}
	public static void main(String[] args) {
		for (Type type: Type.values()) {
			System.out.println(type);
		}
	}

}
