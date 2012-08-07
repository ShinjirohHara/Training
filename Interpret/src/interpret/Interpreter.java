package interpret;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Interpreter extends Frame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextField classDialog;
	private Button ok;

	private ClassAnalyzer currentTask = null;
	private boolean active = false;
	
	public static void main(String[] args) {
		Interpreter iterpreter = new Interpreter();
		iterpreter.setVisible(true);
	}
	
	
	
	public Interpreter() {
		super("Interpreter");
		setSize(400, 200);
		GridBagLayout layOut = new GridBagLayout();
		setLayout(layOut);
		
		GridBagConstraints gdc = new GridBagConstraints();
		gdc.gridx = 0;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.EAST;
		classDialog = new TextField(40);
		layOut.setConstraints(classDialog, gdc);
		add(classDialog);

		gdc.gridx = 1;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.WEST;
		ok = new Button("OK");
		layOut.setConstraints(ok, gdc);
		add(ok);
		ok.addActionListener(this);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	

	
	public void actionPerformed(ActionEvent ae) {
		if (currentTask == null
				&& "OK".equals(ae.getActionCommand())) {
			try {
				currentTask = new ClassAnalyzer(Class.forName(classDialog.getText()));
				currentTask = null;
			} catch (ClassNotFoundException e) {
				String className = classDialog.getText();
				classDialog.setText("class not found:"+className);
			}
		}
	}
}
