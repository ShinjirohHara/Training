package interpret;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class ClassAnalyzer extends JFrame implements MouseListener, InstanceListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class<?> target;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private Object data = null;
	
	public ClassAnalyzer(Class<?> target) {
		this.target = target;
		setTitle(target.getName());
		setSize(500, 250);
		root = new DefaultMutableTreeNode(target.getName());
		tree = new JTree(root);
		tree.addMouseListener(this);
		root.add(setConstructor(target));
		JScrollPane cpane = new JScrollPane(tree);
		add(cpane, BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	Object getData() {
		return data;
	}
	
	
	private MutableTreeNode setConstructor(Class<?> cls) {
		DefaultMutableTreeNode constRoot = new DefaultMutableTreeNode("Constructors");
		for (Constructor<?> elem : cls.getConstructors()) {
			constRoot.add(new ConstructorAnalyzer(elem, this));
		}
		
		return constRoot;
	}

	private void createNewInstance(Object data) {
		this.data = data;
		root.add(getClassNode(target, data));
		((DefaultTreeModel) tree.getModel()).reload();
	}
	
	private DefaultMutableTreeNode getClassNode(Class<?> cls, Object data) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(cls.getName());
		for (Class<?> elem : cls.getInterfaces())
			node.add(getClassNode(elem, data));
		
		if (cls.getSuperclass() != null)
			node.add(getClassNode(cls.getSuperclass(), data));
		
		node.add(setField(cls, data));
		node.add(setMethod(cls, data));
		return node;
	}

	private MutableTreeNode setMethod(Class<?> cls, Object data) {
		DefaultMutableTreeNode methodRoot = new DefaultMutableTreeNode("Method");
		Method[] methos = cls.getMethods();
		for (Method elem : methos) {
			methodRoot.add(new MethodAnalyzer(elem, this));
		}
		return methodRoot;
	}

	private DefaultMutableTreeNode setField(Class<?> cls, Object data) {
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Field");
		Field[] fields = cls.getDeclaredFields();
		for (Field elem : fields) {
			try {
				elem.setAccessible(true);
				root.add(new FieldAnalyzer(elem, this, elem.get(data)));
			} catch (IllegalArgumentException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			}
		}
		return root;
	}

	public void mousePressed(MouseEvent e) {
		
		if (SwingUtilities.isRightMouseButton(e)) {
			System.out.println("this is ClassAnalyzer:"+e.getButton() );
			Object selected = tree.getLastSelectedPathComponent();
			if (selected instanceof FieldAnalyzer) {
				((FieldAnalyzer) selected).mousePressed(e);
			} else if (selected instanceof MethodAnalyzer) {
				((MethodAnalyzer)selected).mousePressed(e);
			} else if (selected instanceof ConstructorAnalyzer) {
				((ConstructorAnalyzer)selected).mousePressed(e);
			} else if (selected instanceof ParameterAnalyzer) {
				((ParameterAnalyzer) selected).mousePressed(e);
			}
		}
	}
	

	
	public void mouseClicked(MouseEvent arg0) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	
	public void receiveNewInstance(Object instance) {
		createNewInstance(instance);
	}

	public void updateField(Field field, Object object) {
		try {
			field.set(data, object);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
