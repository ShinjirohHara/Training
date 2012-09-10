package ch02.ex02_10;


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
	
	public void setSpped(int speed) {
		this.speed = speed;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public String toString() {
		return "ID:"+id+",Speed:"+speed+", Angle:"+angle+", Owner:"+owner;
	}
	
	public static int getCurrentId() {
		return nextId;
	}
	public static void main(String args[]) {
		Vehicle atenza = new Vehicle(200, 10, "hara");
		atenza.setSpped(200);
		atenza.setAngle(10);
		
		Vehicle rx8 = new Vehicle("yamashita");
		rx8.setSpped(250);
		rx8.setAngle(30);
		
		Vehicle mpv = new Vehicle(120, 60, "kidogu");
		mpv.setSpped(120);
		mpv.setAngle(60);
		
		Vehicle crz = new Vehicle(230, 90, "uchida");
		crz.setSpped(230);
		crz.setAngle(90);
		
		Vehicle fit = new Vehicle(80, 120, "hayashi");
		fit.setSpped(80);
		fit.setAngle(120);
	
		System.out.println(atenza);
		System.out.println(rx8);		
		System.out.println(mpv);		
		System.out.println(crz);		
		System.out.println(fit);
		System.out.println("ID:"+Vehicle.getCurrentId());
	}

}
