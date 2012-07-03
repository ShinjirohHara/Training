package ch03.ex03_10;


public class Vehicle implements Cloneable{
	private int speed = 0;
	private int angle = 0;
	private String owner = null;
	private final int id;
	private static int nextId = 0;
	
	public enum Direction {
		TURN_LEFT,
		TURN_RIGHT
	}
	
	public Vehicle () {
		id = nextId++;
	}
	
	public Vehicle (String owner) {
		id = nextId++;
		this.owner = owner;
	}
	
	public Vehicle (int speed, int angle, String owner) {
		id = nextId++;
		
		this.speed = speed;
		this.angle = angle;
		this.owner = owner;
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
	
	public String toString() {
		return "ID:"+id+",Owner:"+owner+",Speed:"+speed+", Angle:"+angle; 
	}
	
	public Vehicle clone() {
		try {
			return (Vehicle)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

}
