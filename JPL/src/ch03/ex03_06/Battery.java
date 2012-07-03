package ch03.ex03_06;


public class Battery extends EnergySource {

	int remainingCapacity;
	@Override
	public boolean empty() {
		
		return (remainingCapacity == 0);
	}

	@Override
	public void feed() {
		remainingCapacity = 100;
	}

}
