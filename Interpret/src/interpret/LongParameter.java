package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.Type;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class LongParameter extends ParameterAnalyzer implements Runnable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LongParameter(Class<Long> param, FieldAnalyzer owner) {
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
		setData(Long.parseLong(psw.getParameter()));
		setUserObject(cls.toString() + ":" + getData());
	}

}
