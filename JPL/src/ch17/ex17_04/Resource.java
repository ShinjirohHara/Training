package ch17.ex17_04;

public interface Resource {
	void user(Object key, Object... args);
	void release();
}
