import static org.junit.Assert.*;

import org.junit.Test;


public class ExtendedLookupImplTest {

	

	@Test
	public void testFind() {
		String name = "name1";
		String value = "value1";
		ExtendedLookup testObject = new ExtendedLookupImpl();
		testObject.add(name, value);
		assert(testObject.find(name).equals(value));
		assertNotNull(testObject.remove(name));
		assertNull(testObject.find(name));
	}
}
