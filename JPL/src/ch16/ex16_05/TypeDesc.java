package ch16.ex16_05;

import java.lang.reflect.*;

public class TypeDesc {

	
	
	private java.io.PrintStream out = System.out;
	
	public static String[]
			basic = {"class", "interface", "enum" , "annotation"},
			supercl = {"extends", "implements"},
			iFace = {null, "extends"};
	
	public void printType(Type type, int depth, String[] labels) {
		if (type == null) return;
		
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>)
			((ParameterizedType)type).getRawType();
		else 
			throw new Error("Unexpected non-class type");
		
		if (cls.equals(Object.class)) return;

		
		for (int i = 0; i < depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3:
			cls.isEnum() ? 2 :
				cls.isInterface() ? 1:  0;
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		
	

		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0 ) {
			out.print('<');
			for (TypeVariable<?> param: params) {
				out.print(param.getName());
				out.print(", ");
			}
			out.print("\b\b>");
		}
		if (cls.isMemberClass()) {
			Class<?> outer = cls.getDeclaringClass();
			out.print(" in "+ outer.getCanonicalName());
		}
		out.println();
		
		
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface : interfaces) {
			printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
		}
		
		printType(cls.getGenericSuperclass(), depth + 1, supercl);
	}
	
	
}
