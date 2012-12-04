package gui2_3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SizeMenu extends JMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum Value {
		SIZE16(16), SIZE32(32), SIZE48(48), SIZE64(64), SIZE128(128), SIZE256(256);
		
		private int size;
		Value(int size) {
			this.size = size;
		}
		
		int getValue() {
			return size;
		}
		
		static Value getValue(String value) {
			Value result = null;
			for (Value element: values()) {
				if (element.size == Integer.parseInt(value)) {
					result = element;
				}
			}
			
			if (result == null) {
				throw new IllegalStateException("size error:"+ value);
			}
			return result;
		}
	}
	Value currentSize;
	public SizeMenu(String name, Value initValue) {
		super(name);
		currentSize = initValue;
		for (Value element: Value.values()) {
			JMenuItem mi = new JMenuItem(String.valueOf(element.getValue()));
			add(mi);
			mi.addActionListener(this);
		}

	}

	public Value getValue() {
		return currentSize;
	}

	
	public void actionPerformed(ActionEvent ae) {
		currentSize = Value.getValue(ae.getActionCommand());
	}

}
