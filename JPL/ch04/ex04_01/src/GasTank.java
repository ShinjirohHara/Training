
public class GasTank implements EnergySource {

	int oil = 0;
	
	
	public boolean empty() {
				
		return (oil == 0);
	}

	
	public void feed() {
		oil += 40;
	}

}
