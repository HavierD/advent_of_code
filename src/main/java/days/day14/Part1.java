package days.day14;

import java.util.ArrayList;
import java.util.List;

public class Part1 {


    private static final List<Point> map = new ArrayList<>();
    private static int height;

    public static void main(String[] args) {

        var input = new Input().input;
        var lines = input.split("\n");
        height = lines.length;
        for (var y = 0; y < lines.length; y++) {
            var points = lines[y].split("");
            for (var x = 0; x < points.length; x++) {
                map.add(new Point(x, y, points[x])) ;
            }
        }

        var circleRocks = getCircleRocks();
        var sum = 0;
        for (var circleRock : circleRocks) {
            var biggestY = findNearestUpperSquarePointYFor(circleRock);
            var countOfCircle = getCountOfCircleBetween(circleRock, biggestY);
            var afterY = biggestY + countOfCircle + 1;
            var load = height - afterY;
            sum += load;
            System.out.println("Circle rock: " + circleRock.getX() + ", " + circleRock.getY() + " -> "  + load);
        }
        System.out.println(sum);

    }

    private static List<Point> getCircleRocks() {

        var circleRocks = new ArrayList<Point>();
        for (var point : map) {
            if (point.getRockType().equals("O")) {
                circleRocks.add(point);
            }
        }
        return circleRocks;
    }

    private static int findNearestUpperSquarePointYFor(Point circleRock) {
        var biggestY = -1;
        for (var p : map) {
            if (p.getX() != circleRock.getX()) {
                continue;
            }
            if (!p.getRockType().equals("#")) {
                continue;
            }
            if (p.getY() >= circleRock.getY()) {
                continue;
            }
            if(p.getY() > biggestY) {
                biggestY = p.getY();
            }
        }
        return biggestY;
    }

    private static int getCountOfCircleBetween(Point circleRock, int squareRockY) {
        var count = 0;
        for (var p : map) {
            if (p.getX() != circleRock.getX()) {
                continue;
            }
            if (!p.getRockType().equals("O")) {
                continue;
            }
            if(p.getY() < squareRockY) {
                continue;
            }
            if (p.getY() >= circleRock.getY()) {
                continue;
            }
            count++;
        }
        return count;
    }
}
