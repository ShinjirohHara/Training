package ch06.ex06_03;


public interface Verbose {
	enum MessageType {
		SILENT, TERSE, NORMAL, VERBOSE
	}
	void setVebosity(MessageType type);
	MessageType getVerbosity();
}
