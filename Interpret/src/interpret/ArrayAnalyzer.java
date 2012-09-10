package interpret;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;


public class ArrayAnalyzer extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	
	private Class<?> classType;
	private Object data = null;
	private JTree tree;
	private DefaultMutableTreeNode root = null;
	
	public ArrayAnalyzer(Class<?> target, int size) {
		if (size < 0) throw new IllegalArgumentException("array size is negative"+size);
		
		classType = target;
		setTitle("Array:"+classType.getName());
		setSize(500, 250);
		root = new DefaultMutableTreeNode("Array:"+classType.getName());
		tree = new JTree(root);
		tree.addMouseListener(this);
		JScrollPane cpane = new JScrollPane(tree);
		add(cpane, BorderLayout.CENTER);
		setVisible(true);
		data = Array.newInstance(classType, size);
		for(int i = 0; i < size; ++i) {
			root.add(new ArrayElement(classType, i, data));
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void mousePressed(MouseEvent me) {
		
		if (SwingUtilities.isRightMouseButton(me)) {
			((ArrayElement)tree.getLastSelectedPathComponent()).mousePressed(me);
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
