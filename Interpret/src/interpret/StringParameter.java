package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class StringParameter extends ParameterAnalyzer implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data = "";
	
	public StringParameter(Class<String> param, FieldAnalyzer owner) {
		super(param, owner);
	}
	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("値を設定する");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(this).start();
	}
	
	
	public void run() {
		ParameterSetWindow psw = new ParameterSetWindow();
		receiveNewInstance(psw.getParameter());
		setUserObject(cls.toString() + ":" + data);
	}
}
