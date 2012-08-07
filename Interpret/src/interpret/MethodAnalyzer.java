package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public class MethodAnalyzer extends DefaultMutableTreeNode implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Method method;
	private ClassAnalyzer classAnalyzer;
	public MethodAnalyzer(Method method, ClassAnalyzer classAnalyzer) {
		super(method.toString());
		this.method = method;
		this.classAnalyzer = classAnalyzer;
		Type[] params = method.getParameterTypes();
		for (Type param : params) {
			ParameterAnalyzer child = ParameterAnalyzer.createParameterAnalyzer(param, null, null);
			child.addConstuctor();
			add(child);
		}
	}

	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("é¿çsÇ∑ÇÈ");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());
	}

	
	public void actionPerformed(ActionEvent ae) {
		Object[] params = new Object[getChildCount()];
		for (int i = 0; i < params.length; i++) {
			params[i] = ((ParameterAnalyzer)getChildAt(i)).getData();
			System.out.println("param"+params[i]+params[i].getClass());
		}
		try {
			System.out.println("object:"+classAnalyzer.getData().getClass());
			System.out.println("method:"+method.getDeclaringClass());
			method.invoke(classAnalyzer.getData(), params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
