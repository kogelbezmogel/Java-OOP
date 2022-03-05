import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {


	final String name;
	HashSet<Sensor> set;

	public AverageSensor(String name) {
		this.name = name;
		this.set = new HashSet<Sensor>();
	}

	public void add(String name) {
		set.add(new TemperatureSensor(name));
	}

	public boolean isOn() {
		for(var i : set) {
			if(!i.isOn())
				return false;
		}
		return true;
	}

    public void setOn() {
    	for(var i : set)
    		i.setOn();
    }

    public void setOff() {
    	for(var i : set)
    		i.setOff();
    }

    public int read() {
    	int sum = 0;
		for(var i : set) {
			if( i.isOn() )
				sum += i.read();
			else
				throw new IllegalStateException();
		}
		return sum / set.size();
    }

    public List<Integer> readings() {
    	List<Integer> list = new ArrayList<Integer>();
    	for(var i : set)
    		list.add(i.read());
    	return list;
    }

}