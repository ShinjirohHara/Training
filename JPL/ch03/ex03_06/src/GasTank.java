
public class GasTank extends EnergySource {

	int oil = 0;
	
	@Override
	public boolean empty() {
				
		return (oil == 0);
	}

	@Override
	public void feed() {
		oil += 40;
	}

}
