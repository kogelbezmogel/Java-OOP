public class Buffer {

    volatile int _capacity;
    volatile int _size;

    public Buffer(int max) {
        _size = 0;
        _capacity = max;
    }

    public synchronized void put() {

        if( _size < _capacity ) {
            _size++;
            System.out.println("Element added to the buffer. Space: " + _size + "/" + _capacity);
        }
        else {
            System.out.println("Buffer full element not added");
        }

    }

    public synchronized void get() {
        
        if( _size > 0 ) {
            _size--;
            System.out.println("Element removed from the buffer. Space: " + _size + "/" + _capacity);
        }
        else {
            System.out.println("Buffer is empty, waiting...");
        }
    }
}