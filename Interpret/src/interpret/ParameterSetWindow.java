package interpret;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ParameterSetWindow extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField classDialog;
	private Button ok;
	private boolean isSetParam;
	
	public ParameterSetWindow() {
		super("値をセットしてください");
		setSize(300,150);
		GridBagLayout layOut = new GridBagLayout();
		setLayout(layOut);
		
		GridBagConstraints gdc = new GridBagConstraints();
		gdc.gridx = 0;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.EAST;
		classDialog = new TextField(25);
		layOut.setConstraints(classDialog, gdc);
		add(classDialog);

		gdc.gridx = 1;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.WEST;
		ok = new Button("OK");
		layOut.setConstraints(ok, gdc);
		add(ok);
		ok.addActionListener(this);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	
	public synchronized String getParameter() {
		while(!isSetParam) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return classDialog.getText();
	}
	
	
	public synchronized void actionPerformed(ActionEvent ae) {
		if ("OK".equals(ae.getActionCommand())) {
			isSetParam = true;
			notifyAll();
			setVisible(false);
		}
		
	}

}
