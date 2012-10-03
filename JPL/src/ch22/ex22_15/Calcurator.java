package ch22.ex22_15;

import java.io.*;

public class Calcurator {
	

	public static void main(String[] args ) throws IOException {
		// example input: 3 5 + cbrt -1 * abs sqrt
		StreamTokenizer st = new StreamTokenizer( new InputStreamReader(System.in));
		st.eolIsSignificant(true);

		while (true) {
			ArrayStack<Double> list = new ArrayStack<Double>();
			while (st.nextToken() != StreamTokenizer.TT_EOL) {
				if(st.ttype == StreamTokenizer.TT_NUMBER) {
					list.push(st.nval);
				} else if (st.ttype == StreamTokenizer.TT_WORD) {
					String ope = st.sval;
					if (ope.equals("sin")) {
						list.push(Math.sin(list.pop()));
					} else if (ope.equals("max")){
						list.push(Math.max(list.pop(), list.pop()));
					} else if (ope.equals("cos")) {
						list.push(Math.cos(list.pop()));
					} else if (ope.equals("min")) {
						list.push(Math.min(list.pop(), list.pop()));
					} else if (ope.equals("abs")) {
						list.push(Math.abs(list.pop()));
					} else if (ope.equals("sqrt")) {
						list.push(Math.sqrt(list.pop()));
					} else if (ope.equals("cbrt")) {
						list.push(Math.cbrt(list.pop()));
					} else {
						throw new UnsupportedOperationException();
					}
				} else {
					switch (st.ttype) {
					case '+':
						list.push(list.pop()+list.pop());
						break;
					case '-':
						list.push(list.pop()-list.pop());
						break;
					case '/': // 改行コードとして認識されてしまう・・・
						list.push(list.pop()/list.pop());
						break;
					case '*':
						list.push(list.pop()*list.pop());
						break;
					case '%':
						list.push(list.pop() % list.pop());
						break;
					default:
						throw new AssertionError("no suuported operation["+(char)st.ttype+"]");
					}
				}
			}

			if (list.getSize() != 1) {
				throw new IllegalArgumentException("list size="+list.getSize());
			}

			System.out.println("="+list.pop());

		}
	}
}
