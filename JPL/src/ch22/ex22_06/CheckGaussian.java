package ch22.ex22_06;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class CheckGaussian {
	
	private final int times = 100000;
	private final Random rnd = new Random();
	private Map<Double, Integer> map = new TreeMap<Double, Integer>();
	
	public void check() {
		for (int i = 0; i < times; i++) {
			double val = new BigDecimal(rnd.nextGaussian()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			
			if (map.containsKey(val)) {
				int num = map.get(val);
				num++;
				map.put(val, num);
			} else {
				map.put(val, 0);
			}
		}
	}
	
	public void print() {
		int union = times/2000;
		for (Iterator<Entry<Double, Integer>> ite = map.entrySet().iterator(); ite.hasNext();) {
			Entry<Double, Integer> entry = ite.next();
			System.out.printf("% .2f", entry.getKey());
			
			String astarisk = "";
			for (int i = 0; i < entry.getValue()/union; i++) {
				astarisk += "*";
			}
			System.out.println(astarisk);
		}
	}
	public static void main(String[] args) {
		CheckGaussian cg = new CheckGaussian();
		cg.check();
		cg.print();
	}

}
