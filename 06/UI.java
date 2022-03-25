import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UI {
    private final Scanner scanner;
    private final Dungeon dungeon;

    public UI(Scanner scanner, Dungeon dungeon) {
        this.scanner = scanner;
        this.dungeon = dungeon;
    }

    public void run() {
        // mapping option list to map
        Map<Character, Option> optionMap = Arrays.stream(Option.values())
                .collect(Collectors.toMap(Option::getCharacter, Function.identity()));

        // printing options:
        System.out.println("Key bindings:");
        optionMap.values().forEach(System.out::println);

        char typedChar; // variable to store pressed key
        System.out.println("Press any key to continue...");
        scanner.next();

        // refresh and print map
        dungeon.refreshMap();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        dungeon.printStatus();
        dungeon.drawMap();
        System.out.print("> ");

        gameLoop: while (true) {
            typedChar = scanner.next().charAt(0);
            Option pickedOption = optionMap.get(typedChar);
            if (pickedOption == null) {
                System.out.println("Option not recognized");
                continue;
            }

            switch (pickedOption) {
            case EXIT:
                break gameLoop;
            case RESET:
                dungeon.reload();
                break;
            // ---------------
            // handling rest of cases here...
            // ---------------
                case LEFT:
                    dungeon.movePlayer(Direction.LEFT);
                    break;
                case RIGHT:
                    dungeon.movePlayer(Direction.RIGHT);
                    break;
                case UP :  
                    dungeon.movePlayer(Direction.UP);
                    break;
                case DOWN : 
                    dungeon.movePlayer(Direction.DOWN);
                    break;
            }

            // refresh and print map
            dungeon.refreshMap();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            dungeon.printStatus();
            dungeon.drawMap();
            System.out.print("> ");

            if (dungeon.isItWin()) {
                System.out.println("You win!");
                break;
            }

            if (dungeon.getMoves() == 0) {
                System.out.println("You lost!");
                break;
            }
        }

        scanner.close();
    }
}
