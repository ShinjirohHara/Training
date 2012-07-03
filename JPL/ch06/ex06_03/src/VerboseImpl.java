
public class VerboseImpl implements Verbose {
	MessageType type = MessageType.NORMAL;
	
	@Override
	public void setVebosity(MessageType type) {
		this.type = type;
	}

	@Override
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
