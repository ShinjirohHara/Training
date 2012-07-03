
public interface Verbose {
	enum MessageType {
		SILENT, TERSE, NORMAL, VERBOSE
	}
	void setVebosity(MessageType type);
	MessageType getVerbosity();
}
