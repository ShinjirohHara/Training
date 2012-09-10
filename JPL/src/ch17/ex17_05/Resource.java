package ch17.ex17_05;

public interface Resource {
	void user(Object key, Object... args);
	void release();
}
