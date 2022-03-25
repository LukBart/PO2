import java.util.Objects;
import java.lang.Math;

public class Vampire {
    private int x;
    private int y;
    public Vampire(int maxX, int maxY) {
        x = (int)(Math.random()*(maxX-1))+1;
        y = (int)(Math.random()*(maxY-1))+1;
        randomize(maxX, maxY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction, int maxX, int maxY) {
        // ---------------
        // move vampire logic here (check if vampire will not move out of map!)...
        // ---------------

        if (y + direction.getY() > maxY - 1 || y + direction.getY() < 0 || 
        x + direction.getX() > maxX - 1 ||x + direction.getX() < 0){
            return;
        }
        x += direction.getX();
        y += direction.getY();
    }

    public void randomize(int maxX, int maxY) {
        // ---------------
        // randomize vampire current position here...
        // ---------------

        int n = (int)(Math.random() * 5);
        switch (n){
            case 4 : move (Direction.LEFT, maxX, maxY); break;
            case 3 : move (Direction.RIGHT, maxX, maxY); break;
            case 2: move (Direction.UP, maxX, maxY); break;
            case 1: move (Direction.DOWN, maxX, maxY); break;
        }
    }

    public boolean isDifferentThanCoordinates(Vampire vampire) {
        return isDifferentThanCoordinates(vampire.getX(), vampire.getY());
    }

    public boolean isDifferentThanCoordinates(int x, int y) {
        // ---------------
        // checking coordinates...
        // ---------------
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vampire))
            return false;
        Vampire vampire = (Vampire) o;
        return getX() == vampire.getX() && getY() == vampire.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "v " + y + ", " + x;
    }
}
