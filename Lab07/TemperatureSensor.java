import java.util.Random;

public class TemperatureSensor implements Sensor {

	final String name;
	int temperature;
	boolean running;

	public TemperatureSensor(String name) {
		this.name = name;
		this.running = false;
		Random ran = new Random();
		this.temperature = (int) ran.nextDouble() * 60 - 30;
	}

	public boolean isOn() {
		if(running)
			return true;
		return false;
	}

	public void setOn() {
		this.running = true;
	}

    public void setOff() {
    	this.running = false;
    }

    public int read() {
    	if (running) {
    		return temperature;
    	}
    	else
    		throw new IllegalStateException();
    }


}