package days.day18;


import java.util.*;

import static days.day18.CrossingType.*;

public class Part2 {

    private static List<LineSegment> lineSegments;

    private static long minX = Long.MAX_VALUE;
    private static long maxX = -Long.MAX_VALUE;
    private static long minY = Long.MAX_VALUE;
    private static long maxY = -Long.MAX_VALUE;


    public static void main(String[] args) {

        List<String> commands = new ArrayList<>();

        var input = new Input().testInput;
        var linesOfInput = input.split("\n");
        part2Init(linesOfInput, commands);

//        part1Init(linesOfInput, commands);


        // set isCrossing for horizontal line segments
        for (var i = 0; i < lineSegments.size(); i++) {
            long previousMinY;
            long nextMinY;
            long previousMaxY;
            long nextMaxY;
            long currentY;
            if (i == 0) {
                previousMinY = lineSegments.get(lineSegments.size() - 1).getMinY();
                nextMinY = lineSegments.get(i + 1).getMinY();
                previousMaxY = lineSegments.get(lineSegments.size() - 1).getMaxY();
                nextMaxY = lineSegments.get(i + 1).getMaxY();
            } else if (i == lineSegments.size() - 1) {
                previousMinY = lineSegments.get(i - 1).getMinY();
                nextMinY = lineSegments.get(0).getMinY();
                previousMaxY = lineSegments.get(i - 1).getMaxY();
                nextMaxY = lineSegments.get(0).getMaxY();
            } else {
                previousMinY = lineSegments.get(i - 1).getMinY();
                nextMinY = lineSegments.get(i + 1).getMinY();
                previousMaxY = lineSegments.get(i - 1).getMaxY();
                nextMaxY = lineSegments.get(i + 1).getMaxY();
            }
            currentY = lineSegments.get(i).getMinY();

            if (previousMinY == currentY && currentY == nextMinY ||
                    previousMaxY == currentY && currentY == nextMaxY) {
                lineSegments.get(i).setZForm(false);
            } else {
                lineSegments.get(i).setZForm(true);
            }

        }


        setLimits();


        long sum = 0;

        // get point counts from the edge
        for (var ls : lineSegments) {
            sum += ls.getCoveredCount();
        }

        lineSegments.sort(Comparator.comparingLong(LineSegment::getMinX));

        for (var yy = 1; yy < maxY; yy++) {

            // when calculating length, startpoint is exclusive and endpoint is inclusive
            var startPoint = 0L;
            var isInside = false;
            for (var ls : lineSegments) {

                if (ls.getCrossingType(yy).equals(NO_CROSSING)) {
                    continue;
                }
                if (ls.getCrossingType(yy).equals(THROUGH_BUT_NO_CROSSING)) {
                    continue;
                }
                if (ls.getCrossingType(yy).equals(DIRECT_CROSSING)) {
                    if (!isInside) {
                        startPoint = ls.getMinX();
                        isInside = true;
                    } else {
                        sum += ls.getMinX() - startPoint - 1;
                        System.out.println(sum);
                        isInside = false;
                    }
                }
                if (ls.getCrossingType(yy).equals(THROUGH_AND_CROSSING)) {
                    if (!isInside) {
                        startPoint = ls.getMaxX();
                        isInside = true;
                    } else {
                        sum += ls.getMinX() - startPoint - 1;
                        System.out.println(sum);
                        isInside = false;
                    }
                }
            }
        }

        System.out.println("sum = " + sum);

    }

    private static void part1Init(String[] linesOfInput, List<String> commands) {
        var lineDrawer = new LineDrawer();
        for (var line : linesOfInput) {
            var direction = line.split(" ")[0];
            var steps = Integer.parseInt(line.split(" ")[1]);
            lineDrawer.drawNextLineTo(direction, steps);
        }
        lineSegments = lineDrawer.getAllLineSegments();
    }

    private static void part2Init(String[] linesOfInput, List<String> commands) {
        for (var line : linesOfInput) {
            int start = line.indexOf('#') + 1;
            int end = line.indexOf(')');
            var command = line.substring(start, end);
            commands.add(command);
        }


        var lineDrawer = new LineDrawer();
        for (var command : commands) {
            var direction = switch (command.toCharArray()[5]) {
                case '0' -> "R";
                case '1' -> "D";
                case '2' -> "L";
                case '3' -> "U";
                default -> throw new RuntimeException("Unknown direction number: " + command.toCharArray()[5]);
            };
            var steps = Integer.parseInt(command.substring(0, 5), 16);
            lineDrawer.drawNextLineTo(direction, steps);
        }

        lineSegments = lineDrawer.getAllLineSegments();
    }

    private static void addIfNotPresent(List<Coordinate> edgeCoordinates, Coordinate c) {
        for (var e : edgeCoordinates) {
            if (e.x() == c.x() && e.y() == c.y()) {
                return;
            }
        }
        edgeCoordinates.add(c);

    }

    private static void setLimits() {
        for (var l : lineSegments) {
            if (l.getMinX() < minX) {
                minX = l.getMinX();
            }
            if (l.getMaxX() > maxX) {
                maxX = l.getMaxX();
            }
            if (l.getMinY() < minY) {
                minY = l.getMinY();
            }
            if (l.getMaxY() > maxY) {
                maxY = l.getMaxY();
            }
        }
    }
}
