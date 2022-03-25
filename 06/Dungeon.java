import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class Dungeon {
    private int moves;
    private List<Vampire> vampires;
    private int playerX = 0;
    private int playerY = 0;
    private final int maxX;
    private final int maxY;
    private final char[][] map;
    int number;

    public Dungeon(int maxX, int maxY, int numberOfVampires, int moves) {
        this.maxX = maxX;
        this.maxY = maxY;
        map = new char[maxX][maxY + 1];
        this.moves = moves;
        number = numberOfVampires;
        addVampires(numberOfVampires);
    }

    public void reload() {
        // ---------------
        // reload map logic here...
        // ---------------
        playerX = 0;
        playerY = 0;
        addVampires(number);        
    }

    public int getMoves() {
        return moves;
    }

    public void printStatus() {
        System.out.println("Current coordinates: (" + playerX + ", " + playerY + ")");
        if (vampires != null)
            vampires.forEach(System.out::println);
        System.out.println("Moves left: " + moves);
    }

    public void refreshMap() {
        moveVampires();
        checkStatus();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                map[i][j] = '.';
            }
            map[i][maxY] = '\n';
        }
        // ---------------
        // 1: print player as '@'
        // 2: print vampires as 'v'
        // ---------------
        
        map [playerY][playerX]= '@';

        
        for (Vampire vamp: vampires){
            map[vamp.getY()][vamp.getX()] = 'V';
        }

    }

    public void drawMap() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    public boolean isItWin() {
        return vampires != null && vampires.size() == 0;
    }

    public void movePlayer(Direction direction) {
        if (playerY + direction.getY() > maxY - 1 || playerY + direction.getY() < 0 || 
        playerX + direction.getX() > maxX - 1 ||playerX + direction.getX() < 0){
            return;
        }
        playerX += direction.getX();
        playerY += direction.getY();
        moves--;
    }

    private void checkStatus() {
        // ---------------
        // check if there are any vampires to delete, and delete them...
        // ---------------
        for (int i = 0; i < vampires.size(); i++){
            if(vampires.get(i).getX() == playerX && vampires.get(i).getY() == playerY)
                vampires.remove(i);
        }

    }

    private void moveVampires() {
        // ---------------
        // move all vampires here (50% to move)...
        // ---------------
        for (int i = 0; i < vampires.size(); i++){
            vampires.get(i).randomize(maxX, maxY);
        }
    }

    private void addVampires(int number) {
        // ---------------
        // add vampires, check if there are not is same position as player or other
        // vampires...
        // ---------------
        int n = number;
        vampires = new ArrayList<>();
        while (n-- > 0 ){
            vampires.add(new Vampire(maxX, maxY));
        }
    }
}
