package interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ObjectSetWindow extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Choice nameList = new Choice();
	private Button ok = new Button("OK");
	private boolean isSetParam = false;
	
	public ObjectSetWindow() {
		super("値をセットしてください。");
		setSize(300,150);
		GridBagLayout layOut = new GridBagLayout();
		setLayout(layOut);
		
		GridBagConstraints gdc = new GridBagConstraints();
		gdc.gridx = 0;
		gdc.gridy = 0;
		
		nameList = new Choice();
		
		for(String name: DataHolder.getNameSet()) {
			nameList.add(name);	
		}
		
		layOut.setConstraints(nameList, gdc);
		add(nameList);

		gdc.gridx = 0;
		gdc.gridy = 1;
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
		return nameList.getSelectedItem();
	}
	
	
	public synchronized void actionPerformed(ActionEvent ae) {
		if ("OK".equals(ae.getActionCommand())) {
			isSetParam = true;
			notifyAll();
			setVisible(false);
		}
	}

}
