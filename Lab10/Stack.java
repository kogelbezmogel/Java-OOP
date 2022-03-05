public class Stack<T> {


	T[] _data;
	int _curr_size;
	int _max_size;

	@SuppressWarnings("unchecked")
	Stack( int max_size ) {
		this._curr_size = 0;
		this._max_size = max_size;

		this._data = (T[]) new Object[max_size];
	}

	public void push( T new_value ) {

		if( _curr_size < _max_size) {
			_data[_curr_size] = new_value;
			_curr_size++;
		}
		else 
			throw new RuntimeException("Stack overflow"); 
	}

	public T pop() {
		if(_curr_size > 0) {
			--_curr_size;
			return _data[_curr_size];
		}
		else
			throw new RuntimeException("Stack is empty");
	}

	public int getCurrentSize() {
		return this._curr_size;
	}

	public int getMaxSize() {
		return this._max_size;
	}

	public void setValueAt( int indeks, T value ) {
		_data[indeks] = value;
	}


	public Stack<T> copy() {
		Stack<T> to_ret = new Stack<T>(_max_size);
		to_ret._data = this._data.clone();
		to_ret._curr_size = this._curr_size;
		return to_ret;
	}

	public boolean isEmpty(){
		if(_curr_size == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if(_curr_size == _max_size)
			return true;
		else
			return false;
	}

	public T valueAt(int i) {
		return _data[i];
	}

}