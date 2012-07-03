
public class PascalTriangle {
	private int depth; 
	private int trianble[][] = null;
	
	PascalTriangle(int depth) {
		this.depth = depth;
		trianble = new int [depth][];

		for (int i = 0; i < depth; i++) {
			trianble[i] = new int[i+1];
			for (int j = 0; j < trianble[i].length; j++) {
				if (j == 0 || j == trianble[i -1].length) {
					trianble[i][j] = 1;
				}else {
					trianble[i][j] = trianble[i-1][j] + trianble[i-1][j-1];
				}
			}
		}
	}
	
	
	
	public void display() {
		String lastLine = "";
		for (int i = 0; i < trianble[depth - 1].length; i++) {
			lastLine += trianble[depth - 1][i] + " ";
		}
		
		
		for (int i = 0; i < depth; i++) {
			String line = "";
			for (int j = 0; j < trianble[i].length; j++) {
				line += trianble[i][j]+" ";
			}
			for (int j = 0; j < (lastLine.length() - line.length()) /2; j++) {
				System.out.print(" ");
			}
			
			System.out.println(line);
		}
	}
	
	public static void main(String args[]) {
		
		PascalTriangle triangle = new PascalTriangle(12);
		triangle.display();
		
		triangle = new PascalTriangle(20);
		triangle.display();
	}
}
