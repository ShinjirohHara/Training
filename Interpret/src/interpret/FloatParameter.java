package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class FloatParameter extends ParameterAnalyzer implements Runnable{

	private float data = 0;
	
	public FloatParameter(Class<Float> param, FieldAnalyzer owner) {
		super(param, owner);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		receiveNewInstance(Float.parseFloat(psw.getParameter()));
		setUserObject(cls.toString() + ":" + getData());
	}

}
