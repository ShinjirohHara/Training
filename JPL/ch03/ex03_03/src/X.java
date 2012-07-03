
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X(int mask) {
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask));
		fullMask = xMask;
		fullMask |= mask;
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask));
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}

}
