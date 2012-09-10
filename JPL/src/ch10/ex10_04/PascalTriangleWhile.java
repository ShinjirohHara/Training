package ch10.ex10_04;


public class PascalTriangleWhile {
	private int depth; 
	private int trianble[][] = null;
	
	PascalTriangleWhile(int depth) {
		this.depth = depth;
		trianble = new int [depth][];

		int i = 0;
		while (i < depth) {
			trianble[i] = new int[i+1];
			int j = 0;
			while (j < trianble[i].length) {
				if (j == 0 || j == trianble[i -1].length) {
					trianble[i][j] = 1;
				}else {
					trianble[i][j] = trianble[i-1][j] + trianble[i-1][j-1];
				}
				j++;
			}
			i++;
		}
	}
	
	
	
	public void display() {
		// 最後の行の長さを調べる
		String lastLine = "";
		int i = 0;
		while (i < trianble[depth - 1].length) {
			lastLine += trianble[depth - 1][i] + " ";
			i++;
		}
		
		i = 0;
		while (i < depth) {
			String line = "";
			int j = 0;
			while (j < trianble[i].length) {
				line += trianble[i][j]+" ";
				j++;
			}
			
			// 空白を表示する
			j = 0;
			while(j < (lastLine.length() - line.length()) /2) {
				System.out.print(" ");
				j++;
			}
			
			System.out.println(line);
			
			i++;
		}
	}
	
	public static void main(String args[]) {
		
		PascalTriangleWhile triangle = new PascalTriangleWhile(12);
		triangle.display();
		
		triangle = new PascalTriangleWhile(20);
		triangle.display();
	}
}
