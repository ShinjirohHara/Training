package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArrayElement extends DefaultMutableTreeNode implements ActionListener, Runnable{
	
	private Class<?> classType;
	private int ordinal;
	private Object arrayData;
	public ArrayElement (Class<?> classType, int ordinal, Object arrayData) {
		super(ordinal+":"+Array.get(arrayData, ordinal)+ "                                        ");
		this.classType = classType;
		this.arrayData = arrayData;
		this.ordinal = ordinal;
	}
	
	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("set value");
		jmi.addActionListener(this);
		popup.add(jmi);
		
		jmi = new JMenuItem("display value");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());
	}

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("set value")) {
			new Thread(this).start();
		} else if (ae.getActionCommand().equals("display value")){ 
			Object value = Array.get(arrayData, ordinal);
			if (value != null) 
				new ResultWindow(value.toString());
			else 
				new ResultWindow("null");
		}
			

	}

	
	public void run() {
		
		
		Object value = null;
		
		if (classType == int.class || classType == Integer.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = Integer.parseInt(psw.getParameter());
		} else if (classType == long.class || classType == Long.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = Long.parseLong(psw.getParameter());
		} else if (classType == boolean.class || classType == Boolean.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = Boolean.parseBoolean(psw.getParameter());
		} else if (classType == float.class || classType == Float.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = Float.parseFloat(psw.getParameter());
		} else if (classType == double.class || classType == Double.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = Double.parseDouble(psw.getParameter());
		} else if (classType == String.class) {
			ParameterSetWindow psw = new ParameterSetWindow();
			value = psw.getParameter();
		} else {
			ObjectSetWindow osw = new ObjectSetWindow();
			value = DataHolder.getData(osw.getParameter());
		}
		
		
		Array.set(arrayData, ordinal, value);
		setUserObject(ordinal+":"+Array.get(arrayData, ordinal));
	}
}
