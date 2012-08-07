package interpret;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public class FieldAnalyzer extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Field field;
	InstanceListener owner;
	private ParameterAnalyzer param;
	
	public FieldAnalyzer(Field field, InstanceListener owner, Object object) {
		super(field.toString()+ "           ");  

		this.field = field;
		this.owner = owner;
		this.param = ParameterAnalyzer.createParameterAnalyzer(field.getType(), object, this);
		setUserObject(field.toString()+ ":"+ param.getData());
	}
	
	
	public void mousePressed(MouseEvent me) {
		param.mousePressed(me);
	}
	
	public void updateField(Object value) {
		owner.updateField(field, value);
		setUserObject(field.toString()+ ":" + param.getData());
	}
}

