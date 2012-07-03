package ch03.ex03_02;


public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X() {
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask));
		fullMask = xMask;
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask));
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}

}
