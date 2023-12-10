package days.day10;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Point> points = new ArrayList<>();
    private List<Point> loop = new ArrayList<>();

    private Point startPoint;

    private int maxX;
    private int maxY;

    public Map(String mapInfo) {
        var lines = mapInfo.split("\n");
        maxY = lines.length;
        for (int y = 0; y < lines.length; y++) {
            var points = lines[y].split("");
            maxX = points.length;
            for (int x = 0; x < points.length; x++) {
                var point = new Point(x, y, points[x]);
                this.points.add(point);
            }
        }
        setConnectedPoints();
        calculateDistances();
        collectLoopPoints();
    }

    public int findFarthestDistance() {
        var farthestDistance = 0;
        for (var p : points) {
            if (p.getDistance() == null) {
                continue;
            }
            if (p.getDistance() > farthestDistance) {
                farthestDistance = p.getDistance();
            }
        }
        return farthestDistance;
    }

    private void calculateDistances() {
        startPoint.setFlagged(true);
        startPoint.setDistance(0);
        startPoint.getConnectedPoint1().setDistance(1);
        startPoint.getConnectedPoint2().setDistance(1);
        List<Point> unFlaggedPoints = collectUnflaggedPointsWithDistance();

        while (!unFlaggedPoints.isEmpty()) {
            var flaggedPoint = flagShortestDistance(unFlaggedPoints);
            var firstConnectedPoint = flaggedPoint.getConnectedPoint1();
            if (firstConnectedPoint != null && !firstConnectedPoint.haveFlagged()) {
                var newDistance = flaggedPoint.getDistance() + 1;
                if (firstConnectedPoint.getDistance() == null) {
                    firstConnectedPoint.setDistance(newDistance);
                } else {
                    firstConnectedPoint.setDistance(Math.min(firstConnectedPoint.getDistance(), newDistance));
                }
            }

            var secondConnectedPoint = flaggedPoint.getConnectedPoint2();
            if (secondConnectedPoint != null && !secondConnectedPoint.haveFlagged()) {
                var newDistance = flaggedPoint.getDistance() + 1;
                if (secondConnectedPoint.getDistance() == null) {
                    secondConnectedPoint.setDistance(newDistance);
                } else {
                    secondConnectedPoint.setDistance(Math.min(secondConnectedPoint.getDistance(), newDistance));
                }
            }

            unFlaggedPoints = collectUnflaggedPointsWithDistance();
        }
    }

    private Point flagShortestDistance(List<Point> unFlaggedPoints) {
        var shortestDistance = Integer.MAX_VALUE;
        Point shortestPoint = null;
        for (var p : unFlaggedPoints) {
            if (p.getDistance() < shortestDistance) {
                shortestDistance = p.getDistance();
                shortestPoint = p;
            }
        }
        assert shortestPoint != null;
        shortestPoint.setFlagged(true);
        shortestPoint.setDistance(shortestDistance);
        return shortestPoint;
    }

    private List<Point> collectUnflaggedPointsWithDistance() {
        var unFlaggedPoints = new ArrayList<Point>();
        for (var p : points) {
            if (p.haveFlagged()) {
                continue;
            }
            if (p.getDistance() == null) {
                continue;
            }
            unFlaggedPoints.add(p);
        }
        return unFlaggedPoints;
    }

    private void setConnectedPoints() {
        for (var p : points) {
            if (p.getType().equals(".")) {
                continue;
            }
            if (p.getType().equals("|")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX(), p.getY() - 1));
                p.setConnectedPoint2(findPointByCoordinates(p.getX(), p.getY() + 1));
                continue;
            }

            if (p.getType().equals("-")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX() - 1, p.getY()));
                p.setConnectedPoint2(findPointByCoordinates(p.getX() + 1, p.getY()));
                continue;
            }
            if (p.getType().equals("L")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX() + 1, p.getY()));
                p.setConnectedPoint2(findPointByCoordinates(p.getX(), p.getY() - 1));
                continue;
            }
            if (p.getType().equals("J")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX() - 1, p.getY()));
                p.setConnectedPoint2(findPointByCoordinates(p.getX(), p.getY() - 1));
                continue;
            }
            if (p.getType().equals("7")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX() - 1, p.getY()));
                p.setConnectedPoint2(findPointByCoordinates(p.getX(), p.getY() + 1));
                continue;
            }
            if (p.getType().equals("F")) {
                p.setConnectedPoint1(findPointByCoordinates(p.getX() + 1, p.getY()));
                p.setConnectedPoint2(findPointByCoordinates(p.getX(), p.getY() + 1));
                continue;
            }
            if (p.getType().equals("S")) {
                startPoint = p;
            }
        }
        for (var x = startPoint.getX() - 1; x <= startPoint.getX() + 1; x++) {
            for (var y = startPoint.getY() - 1; y <= startPoint.getY() + 1; y++) {
                var p = findPointByCoordinates(x, y);
                if (p == null) {
                    continue;
                }
                if (p.getConnectedPoint1() == startPoint || p.getConnectedPoint2() == startPoint) {
                    if (startPoint.getConnectedPoint1() == null) {
                        startPoint.setConnectedPoint1(p);
                    } else {
                        startPoint.setConnectedPoint2(p);
                    }
                }
            }
        }
    }


    private Point findPointByCoordinates(int x, int y) {
        for (var p : points) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    private void collectLoopPoints() {
        loop.add(startPoint);
        var currentPoint = startPoint.getConnectedPoint1();
        while (true) {
            loop.add(currentPoint);
            var point1 = currentPoint.getConnectedPoint1();
            if (!loop.contains(point1)) {
                currentPoint = point1;
                continue;
            }
            var point2 = currentPoint.getConnectedPoint2();
            if (!loop.contains(point2)) {
                currentPoint = point2;
                continue;
            }
            break;
        }
    }

    public List<Point> getLoopPoints() {
        if (loop == null) {
            collectLoopPoints();
        }
        return loop;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public boolean isInside(int x, int y) {

        var fullCross = 0;
        var leftCross = 0;
        var rightCross = 0;

        for (var i = y - 1; i >= 0; i--) {
            var point = findPointByCoordinatesInLoop(x, i);
            if (point == null) {
                continue;
            }

            var type = point.getType();
            if (type.equals("S")) {
                type = transferStartPointType(point);
            }
            if (type.equals("-")) {
                fullCross++;
            }

            if (type.equals("J") || type.equals("7")) {
                leftCross++;
            }
            if (type.equals("F") || type.equals("L")) {
                rightCross++;
            }
        }
        leftCross = leftCross % 2;
        rightCross = rightCross % 2;
        if (leftCross != 0 && rightCross != 0) {
            return (fullCross + 1) % 2 != 0;
        } else if (leftCross == 0 && rightCross == 0) {
            return fullCross % 2 != 0;
        } else {
            throw new RuntimeException("Unknown situation");
        }
    }

    private String transferStartPointType(Point point) {
        var sx = point.getX();
        var sy = point.getY();
        var cx1 = point.getConnectedPoint1().getX();
        var cy1 = point.getConnectedPoint1().getY();
        var cx2 = point.getConnectedPoint2().getX();
        var cy2 = point.getConnectedPoint2().getY();

        if (sy == cy1 && sy == cy2) {
            return "-";
        }
        if (sy == Math.max(cy1, cy2) && sx == Math.max(cx1, cx2) - 1 && sy == Math.min(cy2, cy1) + 1 && sx == Math.min(cx1, cx2)) {
            return "L";
        }
        if (sy == Math.min(cy1, cy2) && sx == Math.max(cx1, cx2) - 1 && sy == Math.max(cy1, cy2) - 1 && sx == Math.min(cx1, cx2)) {
            return "F";
        }
        if ( sx == cx1 && sx == cx2) {
            return "|";
        }
        if (sy == Math.max(cy1, cy2) - 1 && sx == Math.max(cx1, cx2) && sy == Math.min(cy1, cy2) && sx == Math.min(cx1, cx2) + 1) {
            return "7";
        }
        if (sy == Math.min(cy1, cy2) + 1 && sx == Math.max(cx1, cx2) && sy == Math.max(cy1, cy2) && sx == Math.min(cx1, cx2) + 1) {
            return "J";
        }
        throw new RuntimeException("Unknown start point type");

    }

    private Point findPointByCoordinatesInLoop(int x, int i) {
        for (var p : loop) {
            if (p.getX() == x && p.getY() == i) {
                return p;
            }
        }
        return null;
    }



}
