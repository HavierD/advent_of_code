package days.day14;

public class Point {
    private int x;
    private int y;
    private final String rockType;

    private int nextX;
    private int nextY;
    private boolean isXWaitingForMoving = false;
    private boolean isYWaitingForMoving = false;

    public Point(int x, int y, String rockType) {
        this.x = x;
        this.y = y;
        this.rockType = rockType;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getRockType() {
        return rockType;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNextX(int nextX) {
        isXWaitingForMoving = true;
        this.nextX = nextX;
    }

    public void setNextY(int nextY) {
        isYWaitingForMoving = true;
        this.nextY = nextY;
    }

    public void move() {
        if (isYWaitingForMoving && isXWaitingForMoving) {
            throw new RuntimeException("Cannot move both x and y at the same time");
        }
        if (isXWaitingForMoving) {
            x = nextX;
            isXWaitingForMoving = false;
        }
        if (isYWaitingForMoving) {
            y = nextY;
            isYWaitingForMoving = false;
        }

    }
}
