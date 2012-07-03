
public class ImprovedFibonacci {
	private static final String title = "フィボナッチ数列";
	private static final int MAX_INDEX = 10;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(title);
		String[] numSequence = new String[MAX_INDEX];
		

		for (int i = 0; i < MAX_INDEX; i++) {
			if (lo % 2 == 0) {
				numSequence[i] = lo + " *";	
			} else {
				numSequence[i] = Integer.toString(lo);
			}
			
			hi = lo + hi;
			lo = hi - lo;
		}
		
		for (int i = 0; i < MAX_INDEX; i++) {
			System.out.println((i+1) + "番目:" + numSequence[i]);
		}
	}
}
