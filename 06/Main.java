import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI(new Scanner(System.in), new Dungeon(5, 5, 2, 10));
        ui.run();
    }
}
