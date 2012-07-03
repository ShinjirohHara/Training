import static org.junit.Assert.*;

import org.junit.Test;


public class PointTest {

	@Test
	public void testMovePoint() {		
		Point zero = new Point();
		zero.x = 0;
		zero.y = 0;
		
		Point rightUpper = new Point();
		rightUpper.x = 1240;
		rightUpper.y = 1024;
		
		zero.move(rightUpper);
		assertTrue(zero.x == rightUpper.x);
		assertTrue(zero.y == rightUpper.y);

	}	
}
