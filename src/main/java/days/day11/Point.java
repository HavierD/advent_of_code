package days.day11;

public class Point {
    private int x;
    private int y;
    private boolean isStar;
    private Long steps;

    public Point(int x, int y, String starSymbol, Long steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
        if (starSymbol.equals("#")) {
            isStar = true;
        } else if(starSymbol.equals(".")) {
            isStar = false;
        } else {
            throw new IllegalArgumentException("Invalid star symbol: " + starSymbol);
        }
    }

    public Point(int x, int y) {
        this(x, y, "#", null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }
}
