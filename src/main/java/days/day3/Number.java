package days.day3;

import java.util.List;

public class Number {
    private int startX;
    private int endX;
    private int y;
    private int value;
    private boolean isValid;

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void validate(Map map) {
        List<Point> roundedPoints = map.getRoundedPointsByCoordinates(startX, endX, y);
        for (var p : roundedPoints) {
            if (p.getStatus() == StatusEnum.SYMBOL) {
                this.isValid = true;
                return;
            }
        }
        this.isValid = false;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getValue() {
        return value;
    }

    public int getStartX() {
        return startX;
    }

    public int getEndX() {
        return endX;
    }

    public int getY() {
        return y;
    }
}
