package days.day16;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static final List<Tile> tiles = new ArrayList<>();
    private static int width;
    private static int height;

    private static List<Beam> beams = new ArrayList<>();

    public static void main(String[] args) {

        var input = new Input().input;
        var lines = input.split("\n");
        height = lines[0].length();
        for (var y = 0; y < lines.length; y++) {
            var points = lines[y].split("");
            width = points.length;
            for (var x = 0; x < points.length; x++) {
                var tileType = points[x];
                tiles.add(new Tile(x, y, tileType));
            }
        }

        var beam = new Beam(getTileByCoordinate(new Coordinate(0, 0, Direction.RIGHT)), Direction.RIGHT);
        beams.add(beam);
        beaming(beam);

        var sum = 0;
        for (var tile : tiles) {
            if (tile.isEnergized()) {
                sum++;
            }
        }

        System.out.println("sum: " + sum);
    }

    private static void beaming(Beam beam) {

//        printTiles();
        if (!beam.energize()) {
            beams.remove(beam);
            return;
        }
        var nextCoordinates = beam.analyzeNextCoordinate();
        if (nextCoordinates.size() == 1) {
            var nextCoordinate = nextCoordinates.get(0);
            if (!beamToNextTile(beam, nextCoordinate)) {
                beams.remove(beam);
            }
        } else if (nextCoordinates.size() == 2) {
            var nextCoordinate1 = nextCoordinates.get(0);
            beamToNextTile(beam, nextCoordinate1);
            var nextCoordinate2 = nextCoordinates.get(1);
            var nextTile = getTileByCoordinate(nextCoordinate2);
            if (nextTile == null) {
                return;
            }
            var newBeam = new Beam(nextTile, nextCoordinate2.getDirection());
            beams.add(newBeam);
            beamToNextTile(newBeam, nextCoordinate2);

        } else {
            throw new RuntimeException("Unknown nextCoordinates size: " + nextCoordinates.size());
        }
    }

    private static boolean beamToNextTile(Beam beam, Coordinate nextCoordinate) {
        var nextTile = getTileByCoordinate(nextCoordinate);
        if (nextTile == null) {
            beams.remove(beam);
            return false;
        } else {
            beam.walkTo(nextTile);
            beam.setDirection(nextCoordinate.getDirection());
            beaming(beam);
            return true;
        }
    }

    private static Tile getTileByCoordinate(Coordinate nextCoordinate) {
        for (var tile : tiles) {
            if (tile.getX() == nextCoordinate.getX() && tile.getY() == nextCoordinate.getY()) {
                return tile;
            }
        }
        return null;
    }

    private static void printTiles() {
        for (var y = 0; y < height; y++) {
            var line = "";
            for (var x = 0; x < width; x++) {
                var tile = getTileByCoordinate(new Coordinate(x, y, Direction.RIGHT));
                if (!tile.getTileType().equals(".")) {
                    line += tile.getTileType();
                } else {
                    if (tile.isEnergized()) {
                        line += "#";
                    } else {
                        line += ".";
                    }
                }
            }
            System.out.println(line);

        }

        System.out.println();
    }

}
