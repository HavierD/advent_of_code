package days.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {


    private static List<Command> commands = new ArrayList<>();
    private static List<Point> map;
    private static int minX;
    private static int maxX;
    private static int minY;
    private static int maxY;

    public static void main(String[] args) {

        minX = Integer.MAX_VALUE;
        maxX = -Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = -Integer.MAX_VALUE;

        var in = new Input().input;
        var digger = part1Init(in);
        map = digger.getMap();
        setLimits();

        // paint
        var countForTest = 0;
        for (var x = minX; x <= maxX; x++) {
            for (var y = minY; y <= maxY; y++) {

                var point = getPointByCoordinate(x, y);
                if (point == null) {
                    checkStatus(x, y);
                }
                countForTest++;
                if (countForTest % 1000 == 0) {
                    System.out.println(countForTest);
                }
            }
        }
        System.out.println(map.size());
    }

    public static Digger part1Init(String in) {
        var lines = in.split("\n");
        for (var line : lines) {
            var parts = line.split(" ");
            var direction = parts[0];
            var steps = Integer.parseInt(parts[1]);
            var color = parts[2].replaceAll("[()]", "");
            commands.add(new Command(direction, steps, color));
        }

        var digger = new Digger();

        for (var command : commands) {
            digger.dig(command.getSteps(), command.getDirection());
        }
        return digger;
    }

    private static void checkStatus(int x, int y) {
        var upRay = upRay(x, y);
        if (!containsMultiHashes(upRay)) {
            if (countSingleHashes(upRay) % 2 != 0) {
                addNewInnterPointToMap(x, y);
            }
            return;
        }
        var downRay = downRay(x, y);
        if (!containsMultiHashes(downRay)) {
            if (countSingleHashes(downRay) % 2 != 0) {
                addNewInnterPointToMap(x, y);
            }
            return;
        }
        var leftRay = leftRay(x, y);
        if (!containsMultiHashes(leftRay)) {
            if (countSingleHashes(leftRay) % 2 != 0) {
                addNewInnterPointToMap(x, y);
            }
            return;
        }
        var rightRay = rightRay(x, y);
        if (!containsMultiHashes(rightRay)) {
            if (countSingleHashes(rightRay) % 2 != 0) {
                addNewInnterPointToMap(x, y);
            }
            return;
        }
        if (firstTouchDug(upRay) || firstTouchDug(downRay) || firstTouchDug(leftRay) || firstTouchDug(rightRay)) {
            addNewInnterPointToMap(x, y);
            return;
        }
//        if (findAround(x, y)) {
//            addNewPointToMap(x, y);
//        }

//        printMap();
//        throw new RuntimeException("No ray found for x: " + x + " y: " + y);

    }

    private static boolean firstTouchDug(String upRay) {
        var chars = upRay.toCharArray();
        for (var c : chars) {
            if (c == '#') {
                return false;
            }
            if (c == 'O') {
                return true;
            }
        }
        throw new RuntimeException("No O found in ray: " + upRay);
    }

    private static void addNewInnterPointToMap(int x, int y) {
        if (x > maxX || x < minX || y > maxY || y < minY) {
           throw new RuntimeException("Point out of bounds: " + x + " " + y);
        }
        if (getPointByCoordinate(x, y) == null) {
            map.add(new Point(x, y, false));
        }
        paint(x, y);
    }

    private static void paint(int x, int y) {

        for (var yy = y; yy < maxY; yy++) {
            var p = getPointByCoordinate(x, yy);
            if (p != null && p.isEdge()) {
                break;
            }
            for (var xx = x; xx <= maxX; xx++) {
                var point = getPointByCoordinate(xx, yy);
                if (point == null) {
                    map.add(new Point(xx, yy, false));
                    continue;
                }
                if (point.isEdge()) {
                    break;
                }
            }
        }
    }

    private static boolean findAround(int x, int y) {

        if (x < maxX && x > minX && y < maxY && y > minY) {

            var upperPoint = getPointByCoordinate(x, y - 1);
            var lowerPoint = getPointByCoordinate(x, y + 1);
            var leftPoint = getPointByCoordinate(x - 1, y);
            var rightPoint = getPointByCoordinate(x + 1, y);
            if (upperPoint != null && !upperPoint.isEdge()) {
                return true;
            }
            if (lowerPoint != null && !lowerPoint.isEdge()) {
                return true;
            }
            if (leftPoint != null && !leftPoint.isEdge()) {
                return true;
            }
            if (rightPoint != null && !rightPoint.isEdge()) {
                return true;
            }

            return findAround(x, y - 1) || findAround(x, y + 1) || findAround(x - 1, y) || findAround(x + 1, y);
        }
        return false;
    }

    private static void setLimits() {
        for (var point : map) {
            if (point.getX() < minX) {
                minX = point.getX();
            }
            if (point.getX() > maxX) {
                maxX = point.getX();
            }
            if (point.getY() < minY) {
                minY = point.getY();
            }
            if (point.getY() > maxY) {
                maxY = point.getY();
            }
        }
    }

    private static String upRay(int x, int y) {
        var ray = "";
        for (var i = y - 1; i >= minY; i--) {
            var point = getPointByCoordinate(x, i);
            ray = getString(point, ray);
        }
        return ray;
    }

    private static String getString(Point point, String ray) {
        if (point != null) {
            if (point.isEdge()) {
                ray += "#";
            } else {
                ray += "O";
            }
        } else {
            ray += ".";
        }
        return ray;
    }

    private static String downRay(int x, int y) {
        var ray = "";
        for (var i = y + 1; i <= maxY; i++) {
            var point = getPointByCoordinate(x, i);
            ray = getString(point, ray);
        }
        return ray;
    }

    private static String leftRay(int x, int y) {
        var ray = "";
        for (var i = x - 1; i >= minX; i--) {
            var point = getPointByCoordinate(i, y);
            ray = getString(point, ray);
        }
        return ray;
    }

    private static String rightRay(int x, int y) {
        var ray = "";
        for (var i = x + 1; i <= maxX; i++) {
            var point = getPointByCoordinate(i, y);
            ray = getString(point, ray);
        }
        return ray;
    }

    private static Point getPointByCoordinate( int x, int y) {
        if (x > maxX || x < minX || y > maxY || y < minY) {
            throw new RuntimeException("Point out of bounds: " + x + " " + y);
        }

        for (var point : map) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        return null;
    }

    private static boolean containsMultiHashes(String input) {
        Pattern pattern = Pattern.compile("##+");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private static int countSingleHashes(String input) {
        Pattern pattern = Pattern.compile("(?<!#)#(?!#)");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static void printMap () {
        for (var y = minY; y <= maxY; y++) {
            var line = "";
            for (var x = minX; x <= maxX; x++) {
                var point = getPointByCoordinate(x, y);
                line = getString(point, line);
            }
            System.out.println(line);
        }
    }
}
