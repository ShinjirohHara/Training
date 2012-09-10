package ch10.ex10_04;


public class PascalTriangleDoWhile {
	private int depth; 
	private int trianble[][] = null;
	
	PascalTriangleDoWhile(int depth) {
		if (depth < 1) {
			throw new IllegalArgumentException("depth is illegal "+depth);
		}
		this.depth = depth;
		trianble = new int [depth][];

		int i = 0;
		do {
			trianble[i] = new int[i+1];
			int j = 0;
			do {
				if (j == 0 || j == trianble[i -1].length) {
					trianble[i][j] = 1;
				}else {
					trianble[i][j] = trianble[i-1][j] + trianble[i-1][j-1];
				}
				j++;
			} while (j < trianble[i].length);
			i++;
		} while (i < depth);
	}
	
	
	
	public void display() {
		// 最後の行の長さを調べる
		String lastLine = "";
		int i = 0;
		do {
			lastLine += trianble[depth - 1][i] + " ";
			i++;
		} while (i < trianble[depth - 1].length);
		
		i = 0;
		do {
			String line = "";
			int j = 0;
			do {
				line += trianble[i][j]+" ";
				j++;
			} while (j < trianble[i].length);
			
			// 空白を表示する
			j = 0;
			do {
				System.out.print(" ");
				j++;
			} while(j < (lastLine.length() - line.length()) /2);
			System.out.println(line);
			i++;
		} while (i < depth);
	}
	
	public static void main(String args[]) {
		
		PascalTriangleDoWhile triangle = new PascalTriangleDoWhile(12);
		triangle.display();
		
		triangle = new PascalTriangleDoWhile(20);
		triangle.display();
	}
}
