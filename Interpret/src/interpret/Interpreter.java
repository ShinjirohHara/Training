package interpret;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Interpreter extends Frame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextField classDialog;
	private Button ok;

	private List<Object> classList = new ArrayList<Object>();	
	
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
		classDialog = new TextField(30);
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
		if ("OK".equals(ae.getActionCommand())) {
			String className = classDialog.getText();
			if (className.startsWith("Array ")) {
				System.out.println("enter arry");
				String args[] = className.split(" ");
				if (args.length < 3) {
					throw new IllegalArgumentException("too fee argument."+args.length);
				}
				try {
					classList.add(new ArrayAnalyzer(Class.forName(args[1]), Integer.parseInt(args[2])));
				} catch (ClassNotFoundException e) {
					if (getPrimitive(args[1]) != null) {
						classList.add(new ArrayAnalyzer(getPrimitive(args[1]), Integer.parseInt(args[2])));
					} else {
						classDialog.setText("class not found:"+args[1]);
					}
				}
			} else {
				try { 
					classList.add(new ClassAnalyzer(Class.forName(classDialog.getText())));
				} catch (ClassNotFoundException e) {
					classDialog.setText("class not found:"+classDialog.getText());
				}
			}
		}
	}



	private Class<?> getPrimitive(String className) {
		if (className.equals("byte")) return byte.class;
		if (className.equals("short")) return short.class;
		if (className.equals("int")) return int.class;
		if (className.equals("long")) return long.class;
		if (className.equals("char")) return char.class;
		if (className.equals("float")) return float.class;
		if (className.equals("double")) return double.class;
		if (className.equals("boolean")) return boolean.class;
		if (className.equals("void")) return void.class;
		return null;
	}
}
