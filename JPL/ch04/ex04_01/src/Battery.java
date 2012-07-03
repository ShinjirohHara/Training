
public class Battery implements EnergySource {

	int remainingCapacity;
	
	public boolean empty() {
		
		return (remainingCapacity == 0);
	}

	
	public void feed() {
		remainingCapacity = 100;
	}

}
