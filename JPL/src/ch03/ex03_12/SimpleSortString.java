package ch03.ex03_12;


public class SimpleSortString extends SortHarness {

	@Override
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0) {
					swap(i, j);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		String data[] = {"test", "test1", "a", "b"};
		SortHarness sort = new SimpleSortString();
		sort.sort(data);
		System.out.println("Metrics:"+ sort.getMetrics());
		for (int i = 0; i < sort.getDataLength(); i++) {
			System.out.println("\t"+ data[i]);	
		}
	}
}
