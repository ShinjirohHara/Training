package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;


public class ConstructorAnalyzer extends DefaultMutableTreeNode implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Constructor<?> constroctor;
	private InstanceListener listener;
	
	public ConstructorAnalyzer(Constructor<?> elem, InstanceListener listener) {
		super(elem.toString());
		constroctor = elem;
		this.listener = listener;
		
		Type[] params = constroctor.getGenericParameterTypes();
		for (Type param : params) {
			ParameterAnalyzer child = ParameterAnalyzer.createParameterAnalyzer(param, null, null);
			if (child != null) {
				add(child);
			} else {
				setUserObject("NotSupportedMethod");
			}
		}
	}
	
	public void addParameterConstructor() {
		for (int i = 0; i < getChildCount(); i++) {
			((ParameterAnalyzer) getChildAt(i)).addConstuctor();
		}
	}
	
	
	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("インスタンスを生成する");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());

	}


	
	public void actionPerformed(ActionEvent arg0) {
		Object[] params =  new Object[getChildCount()];
		for (int i = 0; i < params.length; i++) {
			params[i] = ((ParameterAnalyzer)getChildAt(i)).getData();
		}
		Object result = null;
		try {
			result = constroctor.newInstance(params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		listener.receiveNewInstance(result);
	}
}
