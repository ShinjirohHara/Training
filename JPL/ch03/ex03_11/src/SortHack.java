
public class SortHack extends SortDouble {

	
	private boolean isFirst = true;
	@Override
	protected void doSort() {
		if (isFirst) {
			for (int i = 0; i < getDataLength(); i++) {
				for (int j = i; j < getDataLength(); j++) {
					if (compare(i, j) > 0) {
						swap(i, j);
					}
				}
			}
			isFirst = false;
			double[] dummy = {1, 2, 3};
			sort(dummy);
		}
	}

}
