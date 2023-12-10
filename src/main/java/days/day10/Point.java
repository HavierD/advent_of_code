package days.day10;

public class Point {
    private final int x;
    private final int y;
    private Point connectedPoint1;
    private Point connectedPoint2;
    private boolean flagged = false;

    private final String type;

    private Integer distance = null;

    public Point(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public void setConnectedPoint1(Point connectedPoint1) {
        this.connectedPoint1 = connectedPoint1;
    }

    public void setConnectedPoint2(Point connectedPoint2) {
        this.connectedPoint2 = connectedPoint2;
    }

    public Point getConnectedPoint1() {
        return connectedPoint1;
    }

    public Point getConnectedPoint2() {
        return connectedPoint2;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setFlagged(boolean foundDistance) {
        this.flagged = foundDistance;
    }

    public boolean haveFlagged() {
        return flagged;
    }

    public Integer getDistance() {
        return distance;
    }
}
