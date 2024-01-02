package days.day16;

public class Coordinate {
    private final int x;
    private final int y;
    private Direction direction;

    public Coordinate(int x, int y , Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
