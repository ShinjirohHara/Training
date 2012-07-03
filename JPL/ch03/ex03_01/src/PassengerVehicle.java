
public class PassengerVehicle extends Vehicle {
	private int capacity = 0;
	private int numberOfPassengers = 0;
	
	public PassengerVehicle(String owner, int capacity) {
		super(owner);
		this.capacity = capacity;
		
	}
	
	final public int getCapacity() {
		return capacity;
	}
	
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	
	
	public String toString() {
		
		return super.toString()+", Capacity:"+capacity+", NumberOfPassengers:"+numberOfPassengers;
	}
	public static void main(String args[]) {
		
		Vehicle atenza = new PassengerVehicle("hara", 5);
		System.out.println(atenza);
	}
}
