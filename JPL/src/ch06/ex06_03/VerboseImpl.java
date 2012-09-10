package ch06.ex06_03;


public class VerboseImpl implements Verbose {
	MessageType type = MessageType.NORMAL;
	
	
	public void setVebosity(MessageType type) {
		this.type = type;
	}

	
	public MessageType getVerbosity() {
		return type;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Verbose target = new VerboseImpl();
		for (MessageType type: MessageType.values()) {
			target.setVebosity(type);
			System.out.println(target.getVerbosity());
		}

	}

}
