package interpret;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultWindow extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextArea classDialog;
	private Button ok;
	
	
	
	public ResultWindow(String resultPalam) {
		super("Result");
		setSize(600,300);
		GridBagLayout layOut = new GridBagLayout();
		setLayout(layOut);
		
		GridBagConstraints gdc = new GridBagConstraints();
		gdc.gridx = 0;
		gdc.gridy = 0;
		//gdc.anchor = GridBagConstraints.;
		if (resultPalam.length() < 60) {
			classDialog = new TextArea(resultPalam, 3, 60);
		} else {
			classDialog = new TextArea(resultPalam, 10, 60);
		}
		layOut.setConstraints(classDialog, gdc);
		add(classDialog);

		gdc.gridx = 0;
		gdc.gridy = 1;
		// gdc.anchor = GridBagConstraints.WEST;
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
	
		
	
	public void actionPerformed(ActionEvent ae) {
		if ("OK".equals(ae.getActionCommand())) {
			setVisible(false);
		}
		
	}

}
