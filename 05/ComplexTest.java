import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {
	@Test
	public void	testToString(){
		String s1 = "2.5 + 13.1i";
		assertEquals (new Complex(2.5, 13.1).toString(), s1);
		String s2 = "4.5";
		assertEquals (new Complex(4.5).toString(), s2);
	}

	@Test
	public void testEqualsAndHashCode(){
		Complex expected = new Complex(2.5, 13.1);
		Complex actual = new Complex(2.5, 13.1);
		assertTrue (expected.equals(actual) && actual.equals(expected));
		assertTrue (actual.hashCode() == expected.hashCode());
	}
	
}