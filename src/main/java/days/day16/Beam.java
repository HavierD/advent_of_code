package days.day16;

import java.util.ArrayList;
import java.util.List;

public class Beam {

    private Direction direction;
    private Tile currentTile;

    public Beam(Tile tile, Direction direction) {
        this.currentTile = tile;
        this.direction = direction;
    }

    public boolean energize() {
        return currentTile.energize(this.direction);
    }

    public void walkTo(Tile tile) {
        currentTile = tile;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Coordinate> analyzeNextCoordinate() {
        var currentX = currentTile.getX();
        var currentY = currentTile.getY();
        var tileType = currentTile.getTileType();

        if (tileType.equals(".")) {
            if (direction.equals(Direction.RIGHT)) {
                var re = new ArrayList<Coordinate>();
                re.add(right(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.LEFT)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.UP)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.DOWN)) {
                var re = new ArrayList<Coordinate>();
                re.add(down(currentX, currentY));
                return re;
            }
            throw new RuntimeException("Unknown direction: " + direction);
        }

        if (tileType.equals("/")) {
            if (direction.equals(Direction.RIGHT)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.LEFT)) {
                var re = new ArrayList<Coordinate>();
                re.add(down(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.UP)) {
                var re = new ArrayList<Coordinate>();
                re.add(right(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.DOWN)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                return re;
            }
            throw new RuntimeException("Unknown direction: " + direction);
        }

        if (tileType.equals("\\")) {
            if (direction.equals(Direction.RIGHT)) {
                var re = new ArrayList<Coordinate>();
                re.add(down(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.LEFT)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.UP)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.DOWN)) {
                var re = new ArrayList<Coordinate>();
                re.add(right(currentX, currentY));
                return re;
            }
            throw new RuntimeException("Unknown direction: " + direction);
        }

        if (tileType.equals("-")) {
            if (direction.equals(Direction.RIGHT)) {
                var re = new ArrayList<Coordinate>();
                re.add(right(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.LEFT)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.UP)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                re.add(right(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.DOWN)) {
                var re = new ArrayList<Coordinate>();
                re.add(left(currentX, currentY));
                re.add(right(currentX, currentY));
                return re;
            }
            throw new RuntimeException("Unknown direction: " + direction);
        }

        if (tileType.equals("|")) {
            if (direction.equals(Direction.RIGHT)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                re.add(down(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.LEFT)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                re.add(down(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.UP)) {
                var re = new ArrayList<Coordinate>();
                re.add(up(currentX, currentY));
                return re;
            } else if (direction.equals(Direction.DOWN)) {
                var re = new ArrayList<Coordinate>();
                re.add(down(currentX, currentY));
                return re;
            }
            throw new RuntimeException("Unknown direction: " + direction);
        }
        throw new RuntimeException("Unknown tile type: " + tileType);
    }

    private static Coordinate right(int currentX, int currentY) {
        return new Coordinate(currentX + 1, currentY, Direction.RIGHT);
    }

    private static Coordinate left(int currentX, int currentY) {
        return new Coordinate(currentX - 1, currentY, Direction.LEFT);
    }

    private static Coordinate up(int currentX, int currentY) {
        return new Coordinate(currentX, currentY - 1, Direction.UP);
    }

    private static Coordinate down(int currentX, int currentY) {
        return new Coordinate(currentX, currentY + 1, Direction.DOWN);
    }

    public Tile getCurrentTile() {
        return currentTile;
    }
}
