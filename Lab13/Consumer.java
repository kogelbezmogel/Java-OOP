public class Consumer extends Thread {

    private volatile Buffer _source;

    public Consumer(Buffer source) {
        _source = source;
    }

    public void run() {

        while(true) {
            System.out.println("Removing element from the buffer, customer: " + this.getName() );
            _source.get();

            try {
                Thread.sleep((int)(Math.random() * 10000));
            } catch (Exception e) { }   
        }
    }
}