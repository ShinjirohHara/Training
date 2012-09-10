package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class IntegerParameter extends ParameterAnalyzer implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int data = 0;
	public IntegerParameter(Class<Integer> param, FieldAnalyzer owner) {
		super(param, owner);
	}
	
	
	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("set parameter");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());
	}
	


	public void actionPerformed(ActionEvent ae) {
		new Thread(this).start();
	}
	
	
	
	public void run() {
		ParameterSetWindow psw = new ParameterSetWindow();
		receiveNewInstance(Integer.parseInt(psw.getParameter()));
		setUserObject(cls.toString() + ":" + getData());
	}
}
