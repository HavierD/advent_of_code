package days.day3;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Point> map = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private int maxX;
    private int maxY;

    public Map(String mapInfo) {
        var linesString = mapInfo.split("\n");
        for (var i = 1; i <= linesString.length; i++) {
            lines.add(new Line(i, linesString[i-1]));
        }
        maxX = lines.get(0).getLine().length();
        maxY = lines.size();
        for (int y = 1; y <= lines.size(); y++) {
            String line = lines.get(y-1).getLine();
            for (int x = 1; x <= line.length(); x++) {
                char status = line.charAt(x-1);
                map.add(new Point(x, y, status));
            }
        }
    }

    public Point findPoint(int x, int y) {
        return map.stream()
                .filter(point -> point.getX() == x && point.getY() == y)
                .findFirst()
                .orElseThrow();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Point> getRoundedPointsByCoordinates(int startX, int endX, int y) {
        var returnedPoints = new ArrayList<Point>();

        // above points if possible
        for (var x = startX - 1; x <= endX + 1; x++) {
            try {
                returnedPoints.add(findPoint(x, y - 1));
            } catch (Exception ignored) {}
        }

        //left point if possible
        try {
            returnedPoints.add(findPoint(startX - 1, y));
        } catch (Exception ignored) {}

        //right point if possible
        try {
            returnedPoints.add(findPoint(endX + 1, y));
        } catch (Exception ignored) {}

        //below points if possible
        for (var x = startX - 1; x <= endX + 1; x++) {
            try {
                returnedPoints.add(findPoint(x, y + 1));
            } catch (Exception ignored) {}
        }

        return returnedPoints;
    }

    public List<Gear> getGears() {
        var gears = new ArrayList<Gear>();
        for (var point : map) {
            if (point.getStatus() == StatusEnum.GEAR) {
                gears.add(new Gear(point.getX(), point.getY(), this));
            }
        }
        return gears;
    }
}
