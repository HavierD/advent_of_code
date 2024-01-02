package days.day16;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private final int x;
    private final int y;
    private final String tileType;
    private boolean isEnergized;
    private final List<Direction> chargedDirections = new ArrayList<>();


    public Tile(int x, int y, String tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
    }

    public boolean energize(Direction direction) {
        isEnergized = true;
        if (chargedDirections.contains(direction)) {
            return false;
        } else {
            chargedDirections.add(direction);
            return true;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTileType() {
        return tileType;
    }

    public boolean isEnergized() {
        return isEnergized;
    }

    public void release(boolean energized) {
        chargedDirections.clear();
        isEnergized = energized;
    }


}
