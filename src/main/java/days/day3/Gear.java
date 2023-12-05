package days.day3;

import java.util.ArrayList;
import java.util.List;

public class Gear {
    private int x;
    private int y;
    private boolean isValid;
    private List<Point> roundedPoints = new ArrayList<>();
    private List<Number> roundedNumbers = new ArrayList<>();
    private int gearRatio;


    public Gear(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        for (var i = x - 1; i <= x + 1; i++) {
            for (var j = y - 1; j <= y + 1; j++) {
                roundedPoints.add(map.findPoint(i, j));
            }
        }
    }


    public void validate(List<Number> numberSet) {
        for (var n : numberSet) {
            insideNumberLoop:
            for (var i = n.getStartX(); i <= n.getEndX(); i++) {
                for (var rp : roundedPoints) {
                    if (rp.getX() == i && rp.getY() == n.getY()) {
                        roundedNumbers.add(n);
                        break insideNumberLoop;
                    }
                }
            }
        }
        if (roundedNumbers.size() > 2) {
            throw new RuntimeException("More than 2 numbers!");
        }
        this.isValid = roundedNumbers.size() == 2;
    }
    public void calculateRatio () {
        if (!isValid) {
            throw new RuntimeException("Gear is not valid!");
        }
        gearRatio = roundedNumbers.get(0).getValue() * roundedNumbers.get(1).getValue();
    }

    public boolean isValid() {
        return isValid;
    }

    public int getGearRatio() {
        return gearRatio;
    }
}
