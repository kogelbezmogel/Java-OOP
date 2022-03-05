
public class Producer extends Thread {

    private Buffer _source;

    public Producer( Buffer source) {
        _source = source;
    }

    public void run() {

            while(true) {
            System.out.println("Adding element to the buffer, producer: " + this.getName() );
            _source.put();

            try {
                Thread.sleep((int)(Math.random() * 10000));
            } catch(Exception e) { } 
        }
    }
}