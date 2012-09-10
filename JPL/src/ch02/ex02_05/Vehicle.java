package ch02.ex02_05;


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
	
	public static void main(String args[]) {
		Vehicle atenza = new Vehicle(200, 10, "hara");
		Vehicle rx8 = new Vehicle(250, 30, "yamashita");
		Vehicle mpv = new Vehicle(120, 60, "kidogu");
		Vehicle crz = new Vehicle(2300, 90, "uchida");
		Vehicle fit = new Vehicle(80, 120, "hayashi");
		
		System.out.println(atenza);		
		System.out.println(rx8);		
		System.out.println(mpv);		
		System.out.println(crz);		
		System.out.println(fit);
	}
	
	public String toString() {
		
		return "ID:"+id+",Speed:"+speed+", Angle:"+angle+", Owner:"+owner;
	}

}
