public class StackUtils {



	static String toString( Stack<?> stack ) {
		String s = "[";

		for(int i = stack.getCurrentSize() - 1; i >= 0; --i) {
			s += stack.valueAt(i) + "";
			if( i > - 1 )
				s+= ", ";
		}
		s += "]";

		return s;
	}

	static boolean equals( Stack<?> stack1, Stack<?> stack2 ) {

		if( !stack1.getClass().equals( stack2.getClass() ) )
			return false;
		else if ( stack1.getCurrentSize() != stack2.getCurrentSize() )
			return false;

		boolean eq = true;
		for( int i = 0; i < stack1.getCurrentSize(); ++i)
			if( !stack1.valueAt(i).equals(stack2.valueAt(i)) )
				eq = false;
		return eq;
	}

	@SuppressWarnings("unchecked")
	static <T> Stack<T> swap(Stack<T> stack, int indeks1, int indeks2 ) {

		if( indeks1 > indeks2 ) {
			int temp1 = indeks1;
			indeks1 = indeks2;
			indeks2 = temp1;
		}
		
		if( indeks1 < 0 || indeks2 < 0 )
			throw new ArrayIndexOutOfBoundsException("Index less than 0");
		if( indeks1 >= stack.getMaxSize() || indeks2 >= stack.getMaxSize() )
			throw new ArrayIndexOutOfBoundsException("Index greater than max stack size");
		if( indeks1 >= stack.getCurrentSize() || indeks2 >= stack.getCurrentSize() )
			throw new ArrayIndexOutOfBoundsException("Index greater than current stack size");

		T temp = (T) new Object();

		temp = stack.valueAt(indeks1);
		stack.setValueAt( indeks1, stack.valueAt(indeks2) );
		stack.setValueAt( indeks2, temp );
		return stack;
	}
}