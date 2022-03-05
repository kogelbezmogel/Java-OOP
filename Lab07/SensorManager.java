import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SensorManager {

    private final Map<String, Sensor> sensorMap;

    public SensorManager() {
        sensorMap = new HashMap<>();
    }

    public void printSensors() {
        sensorMap.values().forEach(System.out::println);
    }

    void addTemperatureSensor(String name) throws SensorPresentException {
        if(sensorMap.containsKey(name))
            throw new SensorPresentException();
        sensorMap.put(name, new TemperatureSensor(name));
    }

    void addAverageSensor(String name) throws SensorPresentException {
        if(sensorMap.containsKey(name))
            throw new SensorPresentException();
        sensorMap.put(name, new AverageSensor(name));
    }

    void addTemperatureSensorToAverageSensor(String average, String temperature) throws SensorNotFoundException {
        if(sensorMap.containsKey(average)) {
            ((AverageSensor) sensorMap.get(average)).add(temperature);
        }
        else 
            throw new SensorNotFoundException();
    }

    void turnOff(String name) throws SensorNotFoundException {
        if(sensorMap.containsKey(name))
            sensorMap.get(name).setOff();
        else
            throw new SensorNotFoundException();
    }

    void turnOn(String name) throws SensorNotFoundException {
        if(sensorMap.containsKey(name))
            sensorMap.get(name).setOff();
        else
            throw new SensorNotFoundException();        
    }

    int getSensorReadings(String name) throws SensorNotFoundException {
        if(sensorMap.containsKey(name))
            return sensorMap.get(name).read();
        else
            throw new SensorNotFoundException();
    
    }

    List<Integer> getAverageSensorReadingList(String name) throws SensorNotFoundException {
        if(sensorMap.containsKey(name))
            return ((AverageSensor) sensorMap.get(name)).readings();
        else
            throw new SensorNotFoundException();
    }

}
