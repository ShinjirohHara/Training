package interpret;

import java.lang.reflect.Field;

public interface InstanceListener {
	public void receiveNewInstance(Object instance);
	
	public void updateField(Field field, Object object);
	

}
