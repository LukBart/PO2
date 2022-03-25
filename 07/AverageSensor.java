import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.lang.IllegalStateException;
import java.util.ArrayList;

public class AverageSensor implements Sensor{
    private Map<String, TemperatureSensor> sensors;

    public AverageSensor(){
        sensors = new HashMap<>();
    }

    public void add(String n){
        sensors.put(n, new TemperatureSensor(n));
    }

    public int read() throws IllegalStateException{
        int result = 0;
        for(TemperatureSensor s: sensors.values()){
            result += s.read();
        }
        return result/sensors.size();
    }
    public void setOn(){
        for(int i = 0; i < sensors.size(); i++){
            sensors.get(i).setOn();
        }
    }

    public void setOff(){
        for(int i = 0; i < sensors.size(); i++){
            sensors.get(i).setOff();
        }
    }

    public boolean isOn(){
        boolean state = true;
        for(TemperatureSensor s: sensors.values()){
            if(!s.isOn()){
                state = false;
            }
        }
        return state;
    }
    
    public List<Integer> readings(){
        List<Integer> listOfTemperatures = new ArrayList<>();
        for(TemperatureSensor s: sensors.values()){
            listOfTemperatures.add(s.read());
        }
        return listOfTemperatures;
    }



}
