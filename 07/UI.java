import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UI {
    private final Scanner scanner;
    private final SensorManager sensorManager;

    public UI(Scanner scanner) {
        this.scanner = scanner;
        sensorManager = new SensorManager();
    }

    public void run() {
        Map<Character, Option> optionMap = Arrays.stream(Option.values())
                .collect(Collectors.toMap(Option::getCharacter, Function.identity()));

        System.out.println("Options:");
        optionMap.values().forEach(System.out::println);

        char typedChar = '0';

        mainLoop: while (true) {
            sensorManager.printSensors();
            System.out.print("> ");
            try {
                typedChar = scanner.next().charAt(0);
            }catch (NoSuchElementException e){
                System.out.println("Nie ma takiego sensoru");
            };

            Option pickedOption = optionMap.get(typedChar);
            if (pickedOption == null) {
                System.out.println("Option not recognized");
                continue;
            }

            String name;
            switch (pickedOption) {
                case EXIT:
                    break mainLoop;
                case ADD_TEMP_SENSOR:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        sensorManager.addTemperatureSensor(name);
                    }catch(SensorPresentException e){
                        System.out.println("Sensor juz istnieje");
                    }
                    break;
                case ADD_AVG_SENSOR:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    // code here...
                    try{
                        sensorManager.addAverageSensor(name);
                    }catch(SensorPresentException e){
                        System.out.println("Sensor juz istnieje");
                    }
                    break;
                case ADD_TEMP_TO_AVG:
                    System.out.println("Average sensor name:");
                    System.out.print("> ");
                    String average = scanner.next();
                    System.out.println("Temperature sensor name: ");
                    System.out.print("> ");
                    String temperature = scanner.next();
                    // code here...
                    try{
                        sensorManager.addTemperatureSensorToAverageSensor(average, temperature);
                    }catch(SensorNotFoundException e){
                        System.out.println("Sensor juz istnieje");
                    }
                    break;
                case TURN_OFF:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    // code here...
                    try{
                        sensorManager.turnOff(name);
                    }catch(SensorNotFoundException e){
                        System.out.println("Sensor nie istnieje");
                    }
                    break;
                case TURN_ON:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    // code here...
                    try{    
                        sensorManager.turnOn(name);
                    }catch(SensorNotFoundException e){
                        System.out.println("Sensor nie istnieje");
                    }
                    break;
                case PRINT_TEMP:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    // code here...
                    try{
                        sensorManager.getSensorReadings(name);
                    }catch(SensorNotFoundException e){
                        System.out.println("Sensor nie istnieje");
                    }
                    break;
                case PRINT_TEMP_LIST:
                System.out.println("Sensor name:");
                System.out.print("> ");
                name = scanner.next();
                    // code here...
                    break;
            }
            System.out.println();
        }
    }
}
