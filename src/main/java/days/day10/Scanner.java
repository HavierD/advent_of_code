package days.day10;

import java.util.List;

public class Scanner {
    private final int maxX;
    private final int maxY;
    private final List<Point> loop;
    private final Map map;

    private int insideCount;

    public Scanner(int maxX, int maxY, List<Point> loop, Map map) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.loop = loop;
        this.map = map;
    }

    public void scan() {
        for (var x = 0; x < maxX; x++) {
            for (var y = 0; y < maxY; y++) {
                if (isOnLoop(x, y)) {
                    continue;
                }
                if (map.isInside(x, y)) {
                    insideCount++;
                }
            }
        }
    }


    private boolean isOnLoop(int x, int y) {
        for (var p : loop) {
            if (p.getX() == x && p.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public int getInsideCount() {
        return insideCount;
    }
}
