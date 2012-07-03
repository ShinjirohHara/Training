package ch02.ex02_15;


public class Vehicle {
	private int speed = 0;
	private int angle = 0;
	private String owner = null;
	private final int id;
	private static int nextId = 0;
	
	
	
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
	
	public int getId() {
		return id;
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
		
		Vehicle rx8 = new Vehicle("yamashita");
		rx8.changeSpeed(250);
		rx8.setAngle(30);
		
		Vehicle mpv = new Vehicle(120, 60, "kidogu");
		mpv.changeSpeed(120);
		mpv.setAngle(60);
		
		Vehicle crz = new Vehicle(230, 90, "uchida");
		crz.changeSpeed(230);
		crz.setAngle(90);
		
		Vehicle fit = new Vehicle(80, 120, "hayashi");
		fit.changeSpeed(80);
		fit.setAngle(120);
	
		System.out.println(atenza);
		System.out.println(rx8);		
		System.out.println(mpv);		
		System.out.println(crz);		
		System.out.println(fit);
		System.out.println("ID:"+Vehicle.getCurrentId());
	}

}
