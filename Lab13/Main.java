class Main {

    public static void main( String[] args ) {

        Buffer buf = new Buffer(2);
        Producer prod = new Producer(buf);
        Consumer cons = new Consumer(buf);
        Producer prod2 = new Producer(buf);
        Consumer cons2 = new Consumer(buf);

        prod.start();
        cons.start();
        prod2.start();
        cons2.start();
    } 
}