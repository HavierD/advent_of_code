package days.day14;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static final List<Point> circleRocks = new ArrayList<>();
    private static final List<Point> squareRocks = new ArrayList<>();
    private static int height;
    private static int width;

    public static void main(String[] args) {


        var frequentList = List.of(84314, 84299, 84268, 84239, 84206, 84202, 84191, 84210, 84220, 84237, 84244, 84276, 84294, 84328, 84341, 84341, 84332, 84332);
        var last = (1000000000 - 500) % 18;
        System.out.println(frequentList.get(last - 1));




        var input = new Input().input;
        var lines = input.split("\n");
        height = lines.length;
        for (var y = 0; y < lines.length; y++) {
            var points = lines[y].split("");
            width = points.length;
            for (var x = 0; x < points.length; x++) {
                if (points[x].equals("O")) {
                    circleRocks.add(new Point(x, y, points[x]));
                } else if (points[x].equals("#")) {
                    squareRocks.add(new Point(x, y, points[x]));
                }
            }
        }

        var patternFinder = new PatternFinder();
        // 1000000 times
        for (var i = 0; i < 518; i++) {


            var print = false;

            tiltUp();
            if (print) printMap();
            tileLeft();
            if (print) printMap();
            tiltDown();
            if (print) printMap();
            tileRight();
            if (print) printMap();
            if (print) System.out.println();
            patternFinder.addValue(getTotalLoad());
        }
        patternFinder.analyze();

        // for test:
        // 65 64 65 63 68 69 69, from fifth:
//        var last = (1000000000 - 4) % 7;
//        System.out.println(last);

        // for real:
        // 84314 84299 84268 84239 84206 84202 84191 84210 84220 84237 84244 84276 84294 84328 84341 84341 84332 84332
//        var frequentList = List.of(84314, 84299, 84268, 84239, 84206, 84202, 84191, 84210, 84220, 84237, 84244, 84276, 84294, 84328, 84341, 84341, 84332, 84332);
//        var last = (1000000000 - 500) % 18;
//        System.out.println(frequentList.get(last - 1));

    }

    private static int getTotalLoad() {
        var sum = 0;
        for (var circleRock : circleRocks) {
            var load = height - circleRock.getY();
            sum += load;
        }
        return sum;
    }

    private static void printMap() {
        List<String> lines = new ArrayList<>();
        for (var y = 0; y < height; y++) {
            var line = "";
            for (var x = 0; x < width; x++) {
                var point = findPoint(x, y);
                if (point == null) {
                    line += ".";
                    continue;
                }
                line += point.getRockType();
            }
            lines.add(line);
        }
        for (var line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }

    private static Point findPoint(int x, int y) {

        for (var circleRock : circleRocks) {
            if (circleRock.getX() == x && circleRock.getY() == y) {
                return circleRock;
            }
        }
        for (var squareRock : squareRocks) {
            if (squareRock.getX() == x && squareRock.getY() == y) {
                return squareRock;
            }
        }
        return null;
    }

    private static void tiltUp() {
        for (var circleRock : circleRocks) {
            var biggestY = findNearestUpperSquarePointYFor(circleRock);
            var countOfCircle = getCountOfCircleVerticallyBetween(circleRock, biggestY);
            var afterY = biggestY + countOfCircle + 1;
            circleRock.setNextY(afterY);
        }
        circleRocks.forEach(Point::move);
    }

    private static void tileLeft() {
        for (var circleRock : circleRocks) {
            var biggestX = findNearestLeftSquarePointXFor(circleRock);
            var countOfCircle = getCountOfCircleHorizontallyBetween(circleRock, biggestX);
            var afterX = biggestX + countOfCircle + 1;
            circleRock.setNextX(afterX);
        }
        circleRocks.forEach(Point::move);
    }


    private static void tiltDown() {
        for (var circleRock : circleRocks) {
            var smallestY = findNearestDownerSquarePointYFor(circleRock);
            var countOfCircle = getCountOfCircleVerticallyBetween(circleRock, smallestY);
            var afterY = smallestY - countOfCircle - 1;
            circleRock.setNextY(afterY);
        }
        circleRocks.forEach(Point::move);
    }

    private static void tileRight() {
        for (var circleRock : circleRocks) {
            var smallestX = findNearestRightSquarePointXFor(circleRock);
            var countOfCircle = getCountOfCircleHorizontallyBetween(circleRock, smallestX);
            var afterX = smallestX - countOfCircle - 1;
            circleRock.setNextX(afterX);
        }
        circleRocks.forEach(Point::move);
    }


    private static int findNearestUpperSquarePointYFor(Point circleRock) {
        var biggestY = -1;
        for (var p : squareRocks) {
            if (p.getX() != circleRock.getX()) {
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

    private static int findNearestDownerSquarePointYFor(Point circleRock) {
        var smallestY = width;
        for (var p : squareRocks) {
            if (p.getX() != circleRock.getX()) {
                continue;
            }
            if (p.getY() <= circleRock.getY()) {
                continue;
            }
            if(p.getY() < smallestY) {
                smallestY = p.getY();
            }
        }
        return smallestY;
    }


    private static int findNearestLeftSquarePointXFor(Point circleRock) {
        var biggestX = -1;
        for (var p : squareRocks) {
            if (p.getY() != circleRock.getY()) {
                continue;
            }
            if (p.getX() >= circleRock.getX()) {
                continue;
            }
            if(p.getX() > biggestX) {
                biggestX = p.getX();
            }
        }
        return biggestX;
    }

    private static int findNearestRightSquarePointXFor(Point circleRock) {
        var smallestX = height;
        for (var p : squareRocks) {
            if (p.getY() != circleRock.getY()) {
                continue;
            }
            if (p.getX() <= circleRock.getX()) {
                continue;
            }
            if(p.getX() < smallestX) {
                smallestX = p.getX();
            }
        }
        return smallestX;
    }


    private static int getCountOfCircleVerticallyBetween(Point circleRock, int squareRockY) {
        var count = 0;
        for (var p : circleRocks) {
            if (p.getX() != circleRock.getX()) {
                continue;
            }
            if(p.getY() <= Math.min(squareRockY, circleRock.getY())) {
                continue;
            }
            if (p.getY() >= Math.max(squareRockY, circleRock.getY())) {
                continue;
            }
            count++;
        }
        return count;
    }

    private static int getCountOfCircleHorizontallyBetween(Point circleRock, int squareRockX) {
        var count = 0;
        for (var p : circleRocks) {
            if (p.getY() != circleRock.getY()) {
                continue;
            }
            if(p.getX() <= Math.min(squareRockX, circleRock.getX())) {
                continue;
            }
            if (p.getX() >= Math.max(squareRockX, circleRock.getX())) {
                continue;
            }
            count++;
        }
        return count;
    }

}
