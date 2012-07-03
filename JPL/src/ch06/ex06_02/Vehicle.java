package ch06.ex06_02;


public class Vehicle {
	private int speed = 0;
	private int angle = 0;
	private String owner = null;
	private final int id;
	private static int nextId = 0;
	private Direction direction = Direction.LEFT;
	
	public enum Direction {
		LEFT,
		RIGHT
	}
	
	public Vehicle () {
		id = nextId++;
	}
	
	public Vehicle(String owner) {
		id = nextId++;
		this.owner = owner;
	}
	
	public Vehicle(int speed, int angle, String owner) {
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
	
	public int getId() {
		return id;
	}
	
	public void turn(int angle) {
		if (Direction.LEFT == direction) {
			this.angle += angle;
		} else if (Direction.RIGHT == direction){
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
	
	public void turn(Direction direction) {
		this.direction = direction;
	}
	
	public static int getCurrentId() {
		return nextId;
	}
	
	public String toString() {
		return "ID:"+id+",Speed:"+speed+", Angle:"+angle+", Owner:"+owner;
	}
	public static void main(String args[]) {
		Vehicle atenza = new Vehicle(200, 10, "hara");
		atenza.changeSpeed(200);
		atenza.setAngle(10);
		System.out.println(atenza);
		atenza.turn(Direction.LEFT);
		atenza.turn(90);
		System.out.println(atenza);
		atenza.turn(Direction.RIGHT);
		atenza.turn(90);
		System.out.println(atenza);
		atenza.turn(90);
		System.out.println(atenza);
	}
	

}
