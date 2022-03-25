import java.lang.Math;
import java.lang.IllegalStateException;

public class TemperatureSensor implements Sensor{
    private String name;
    private final int temperature;
    private boolean state;
    TemperatureSensor (String n){
        name = n;
        temperature = (int)(Math.random()*60) - 30;
        state = true;
    }

    public void setOn(){
        state = true;
    }

    public void setOff(){
        state = false;
    }

    public boolean isOn(){
        return state;
    }

    public int read() throws IllegalStateException{
        
        if(state == false){
            throw new IllegalStateException();
        }
        return temperature;
    }

    @Override
    public String toString(){
        return name + ", running: " + state;
    }

}
