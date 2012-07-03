
public class ExtendBench extends Benchmark {

	
	private final int loopNum;
	
	public ExtendBench(int loopNum) {
		this.loopNum = loopNum;
	}
	
	@Override
	void benchmark() {
		for (int i = 0; i < loopNum; ++i) {
			// nothing to do
		}
		return;
	}
	
	public static void main(String[] args) {
		
		int loopNum = 10;
		Benchmark bench = new ExtendBench(loopNum);
		
		int count = 10;
		long time = bench.repeat(count);
		System.out.println(count+ "methods in "+loopNum+ "times loop " +time+" nanoseconds");
		
	}
}
