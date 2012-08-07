package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;


public class ParameterAnalyzer extends DefaultMutableTreeNode implements ActionListener, InstanceListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Class<?> cls;
	
	private Object data = null;

	private FieldAnalyzer owner;

	@SuppressWarnings("unchecked")
	public static ParameterAnalyzer createParameterAnalyzer(Type param, Object object, FieldAnalyzer owner) {
		ParameterAnalyzer result = null;
		if (param == int.class || param == Integer.class) {
			result = new IntegerParameter((Class<Integer>)param, owner);
		} else if (param == long.class || param == Long.class) {
			result = new LongParameter((Class<Long>)param, owner);
		} else if (param == boolean.class || param == Boolean.class) {
			result = new BooleanParameter((Class<Boolean>)param, owner);
		} else if (param == float.class || param == Float.class) {
			result = new FloatParameter((Class<Float>)param, owner);
		} else if (param == double.class || param == Double.class) {
			result = new DoubleParam((Class<Double>)param, owner);
		} else if (param == String.class) {
			result = new StringParameter((Class<String>)param, owner);
		} else if (param instanceof Class<?>){
			result = new ParameterAnalyzer((Class<?>) param, owner);
		}
		if (result != null) {
			result.setData(object);
			result.setUserObject(result.cls.toString() + ":" + result.getData());
		}
		
		return result;
	}
	public ParameterAnalyzer(Class<?> param, FieldAnalyzer owner) {
		super(param.toString()+ ": null               ");
		this.cls = param;
		this.owner = owner;

	}
	
	void addConstuctor() {
		for (Constructor<?> elem : cls.getConstructors()) {
			add(new ConstructorAnalyzer(elem, this));
		}
	}
	
	public void mousePressed(MouseEvent me) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem jmi = new JMenuItem("インスタンスを生成する");
		jmi.addActionListener(this);
		popup.add(jmi);
		popup.show(me.getComponent(), me.getX(), me.getY());
	}

	
	public void actionPerformed(ActionEvent ae) {
		try {
			data = cls.newInstance();
			setUserObject(cls.toString() + ":" + data.hashCode());
			Field[] fields = cls.getDeclaredFields();
			for (Field elem : fields) {
				try {
					elem.setAccessible(true);
					add(new FieldAnalyzer(elem, this, elem.get(data)));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (InstantiationException e) {
			System.out.println("未サポートです。："+ cls.toString());
		} catch (IllegalAccessException e) {
			System.out.println("アクセス権限がありません。："+ cls.toString());
		}
	}
	
	
	
	final public void setData(Object data) {
		this.data = data;
	}
	
	final public Object getData(){
		return data;
	}
	
	
	public String toString() {
		String result = cls.toString() + " : " + data;
		int length = 30 - result.length();
		for (int i = 0; i < length; i++)
			result += " ";
		
		return result;
	}
	
	
	public void receiveNewInstance(Object instance) {
		setData(instance);
		if (owner != null) {
			owner.updateField(instance);
		}
	}
	
	public void updateField(Field field, Object object) {
		try {
			field.set(data, object);
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
