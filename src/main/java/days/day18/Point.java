package days.day18;

public class Point {

    private int x;
    private int y;
    private boolean isEdge;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean isEdge) {
        this.x = x;
        this.y = y;
        this.isEdge = isEdge;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void dig() {
        isEdge = true;
    }

    public boolean isEdge() {
        return isEdge;
    }

}
