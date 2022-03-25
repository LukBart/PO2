public enum Direction {
    LEFT(0, -1),
    RIGHT(0, 1),
    DOWN(1, 0),
    UP(-1, 0);

    int x;
    int y;

    Direction (int moveY, int moveX){
        x = moveX;
        y = moveY;
    }

    public int getY() {
        return y;
    }

    public int getX(){
        return x;
    }
    @Override
    public String toString (){
        return super.toString() +" [" + y + ", " + x + "]";
    }

}
