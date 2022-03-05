import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexFunctionTest {


	@Test
	public void add() {
		Complex expected = new Complex(-6.0, 12.2);
		assertEquals( expected, ComplexOperations.add(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public void divide() {
		Complex expected = new Complex(11.0, 14.0);
		assertEquals( expected, ComplexOperations.divide(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public void substract() {
		Complex expected = new Complex(-0.4522310429783739, -1.4932931836846426);
		assertEquals( expected, ComplexOperations.substract(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public void multiply() {
		Complex expected = new Complex( -9.46, -113.6 );
		assertEquals( expected, ComplexOperation.multiply(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

}