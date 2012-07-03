
public class Vehicle {
	private int speed = 0;
	private int angle = 0;
	private String owner = null;
	private final int id;
	private static int nextId = 0;
	
	public Vehicle (int speed, int angle, String owner) {
		id = nextId;
		nextId++;
		this.speed = speed;
		this.angle = angle;
		this.owner = owner;
	}
	
	
	public String toString() {
		
		return "ID:"+id+",Speed:"+speed+", Angle:"+angle+", Owner:"+owner;
	}

}
