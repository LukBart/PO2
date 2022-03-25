import java.util.HashMap;
import java.util.Map;

public class SensorManager {

    private final Map<String, Sensor> sensorMap;

    public SensorManager() {
        sensorMap = new HashMap<>();
    }

    public void printSensors() {
        sensorMap.values().forEach(System.out::println);
    }

    public void addTemperatureSensor(String n) throws SensorPresentException{
        if(sensorMap.containsKey(n))
            throw new SensorPresentException();
        sensorMap.put(n, new TemperatureSensor(n));
    }

    void addAverageSensor(String name) throws SensorPresentException{
        if(sensorMap.containsKey(name)){
            throw new SensorPresentException();
        }
        sensorMap.put(name, new AverageSensor());
    }

    void addTemperatureSensorToAverageSensor(String average, String temperature) throws SensorNotFoundException{
        if (!sensorMap.containsKey(average)){
            throw new SensorNotFoundException();
        }

        ((AverageSensor)sensorMap.get(average)).add(temperature);
    }

    void turnOff(String name) throws SensorNotFoundException{
        if (!sensorMap.containsKey(name)){
            throw new SensorNotFoundException();
        }
        sensorMap.get(name).setOff();
    }
    void turnOn(String name) throws SensorNotFoundException{
        if (!sensorMap.containsKey(name)){
            throw new SensorNotFoundException();
        }
        sensorMap.get(name).setOn();
    }

    int getSensorReadings(String name) throws SensorNotFoundException{
        if (!sensorMap.containsKey(name)){
            throw new SensorNotFoundException();
        }
        return sensorMap.get(name).read();
    }

}
