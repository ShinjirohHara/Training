
public class Vehicle {
	private int speed = 0;
	private int angle = 0;
	private String owner = null;
	private final int id;
	private static int nextId = 0;
	final private EnergySource source;
	
	public enum Direction {
		TURN_LEFT,
		TURN_RIGHT
	}
	
	public Vehicle (EnergySource source) {
		id = nextId++;
		this.source = source;
	}
	
	public Vehicle (String owner, EnergySource source) {
		id = nextId++;
		this.owner = owner;
		this.source = source;
	}
	
	public Vehicle (int speed, int angle, String owner, EnergySource source) {
		id = nextId++;
		
		this.speed = speed;
		this.angle = angle;
		this.owner = owner;
		this.source = source;
	}
	
	public void changeSpeed(int speed) {
		this.speed = speed;
	}
	
	public void stop() {
		this.speed = 0;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public String getOwner() {
		return owner;
	}
	
	final public int getId() {
		return id;
	}
	
	public void turn(int angle, Direction direction) {
		if (Direction.TURN_LEFT == direction) {
			this.angle += angle;
		} else if (Direction.TURN_RIGHT == direction){
			this.angle -= angle;
		} else {
			throw new IllegalArgumentException("Bad direction"+direction);
		}
		
		if (this.angle > 360) {
			this.angle = this.angle - 360;
		} else if (this.angle < 0) {
			this.angle = this.angle + 360;
		}
	}
	
	
	
	public static int getCurrentId() {
		return nextId;
	}
	
	
	public void start() {
		if (source.empty()) {
			source.feed();
		}
		changeSpeed(20);
	}
	
	public String toString() {
		return "ID:"+id+",Speed:"+speed+", Angle:"+angle+", Owner:"+owner;
	}
	
	
	public static void main(String args[]) {
		Vehicle gasCar = new Vehicle("hara", new GasTank());
		Vehicle elecCar = new Vehicle("mase", new Battery());
		gasCar.start();
		elecCar.start();
		
		System.out.println(gasCar);
		System.out.println(elecCar);

	}
}
