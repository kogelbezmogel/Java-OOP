
public class ComplexFunctionTest {


	@Test
	public add() {
		Complex expected = new Complex(-6.0, 12.2);
		assertEquals( expected, ComplexOperations.add(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public divide() {
		Complex expected = new Complex(11.0, 14.0);
		assertEquals( expected, ComplexOperations.divide(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public substract( -0.4522310429783739, -1.4932931836846426 ) {
		Complex expected = new Complex();
		assertEquals( expected, ComplexOperations.substract(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

	@Test
	public multiply( -9.46, -113.6 ) {
		Complex expected = new Complex();
		assertEquals( expected, ComplexOperation.multiply(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)) );
	}

}