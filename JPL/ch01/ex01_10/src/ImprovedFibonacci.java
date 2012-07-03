
public class ImprovedFibonacci {
	private static final String title = "フィボナッチ数列";
	private static final int MAX_INDEX = 10;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(title);
		Element[] numSequence = new Element[MAX_INDEX];
		

		for (int i = 0; i < MAX_INDEX; i++) {
			numSequence[i] = new Element(lo);
			hi = lo + hi;
			lo = hi - lo;
		}
		
		for (int i = 0; i < MAX_INDEX; i++) {
			System.out.println((i+1) + "番目:" + numSequence[i]);
		}
	}
}
