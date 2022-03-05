import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {


	@Test
	public void testToString() {
		String expected = "5.1i";
		assertEquals( expected, Complex( 0.0, 5.1 ).toString() );
	}

	@Test
	public void testEqualsAndHashCode() { 

		Complex c1 = new Complex( 0.0, 5.1 );
		Complex c2 = new Complex( 0.0, 5.1 );
		int expected = c1.hashCode();

		assertEquals( expected, c2.hashCode() );
	}
}