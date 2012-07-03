package ch10.ex10_03;


public class Week {

	enum Type {
		MONDAY, TUESDAY, WEDNESDAY, THURTHAY, FRIDAY, SATURDAY, SUNDAY 
	}
	public static void main(String[] args) {
		System.out.println(isWorkByIfElse(Type.FRIDAY));
		System.out.println(isWorkBySwitchCase(Type.SATURDAY));
		
	}
	
	public static boolean isWorkByIfElse(Type eType) {
		boolean result;
		if (eType == Type.MONDAY
				|| eType == Type.TUESDAY
				|| eType == Type.WEDNESDAY
				|| eType == Type.THURTHAY
				|| eType == Type.FRIDAY) {
			result = true;
		} else if (eType == Type.SUNDAY
				|| eType == Type.SATURDAY) {
			result = false;
		} else {
			throw new AssertionError("unknown week:"+ eType);
		}
		return result;
	}
	
	public static boolean isWorkBySwitchCase(Type eType) {
		boolean result;
		switch (eType) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURTHAY:
		case FRIDAY:
			result = true;
			break;
		case SATURDAY:
		case SUNDAY:
			result = false;
			break;
			
		default:
			throw new AssertionError("unknown week"+ eType);
		}
		return result;
	}

}
