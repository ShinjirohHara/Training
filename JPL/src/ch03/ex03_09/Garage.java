package ch03.ex03_09;


public class Garage implements Cloneable{
	private static final int max_size = 10;
	private int current = 0;
	private Vehicle[] container = new Vehicle[max_size];
	
	
	
	public void add(Vehicle elem) {
		if (max_size > current) {
			container[current] = elem;
			++current;
		}
	}
	
	public Vehicle get(int pos) {
		if (pos < current) {
			return container[pos];
		}
		return null;
	}
	
	public String toString() {
		String result = "";
		final String kaigyo = System.getProperty("line.separator"); 
		for (int i = 0; i < current; i++) {
			result = result + container[i] + kaigyo;
		}
		return result;
	}
	
	public Garage clone() {
		try {
			Garage clone = (Garage) super.clone();
			clone.container = container.clone();
			for (int i = 0; i < current; ++i) {
				clone.container[i] = container[i].clone();
			}
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
	public static void main(String args[]) {
		Garage garage = new Garage();
		Vehicle satoh = new Vehicle("satoh");
		garage.add(satoh);
		Vehicle hara = new Vehicle("hara");
		garage.add(hara);
		Vehicle suzuki = new Vehicle("suzuki");
		garage.add(suzuki);
		
		System.out.println("original Garage:");
		System.out.println(garage);
		Garage garage_clone = garage.clone();
		System.out.println("clone Garage:");
		System.out.println(garage_clone);
		
		Vehicle satoh_clone = garage_clone.get(0);
		satoh_clone.changeSpeed(200);
		System.out.println("original Garage:");
		System.out.println(garage);
		System.out.println("clone Garage:");
		System.out.println(garage_clone);
	}

}
