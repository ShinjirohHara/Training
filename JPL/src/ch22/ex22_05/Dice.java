package ch22.ex22_05;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Dice {
	private static final Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
	private final Random random = new Random();
	
	public int shoot() {
		return random.nextInt(6)+1;
	}

	
	public static void main(String[] args) {
		
		int times = 10000;
		int diceNum = 5;
				
		for (int i = 1; i < times; i++) {
			int sum = calculateDiceShootAvarage(diceNum);
			if (map.containsKey(sum)) {
				int num = map.get(sum);
				num++;
				map.put(sum, num);
			} else {
				map.put(sum, 1);
			}
		}
		
		
		for (int i = 1; i < 6*diceNum + 1; i++) {
			if (map.get(i) != null)
				System.out.println("Sum:["+i + "]:"+(double)map.get(i)/ (double)times);
		}
		
		
	}



	private static int calculateDiceShootAvarage(int num) {
		Dice[] list = new Dice[num];
		for (int i = 0; i < num; i++){
			list[i] = new Dice();
		}
		
		
		int sum = 0;
		for (int j = 0; j < num; j++) {
			sum += list[j].shoot();;
		}
		
		return sum;
		
	}
	
	

}
