package days.day18;

import java.util.ArrayList;
import java.util.List;

public class LineDrawer {

    private Coordinate currentCoordinate = new Coordinate(0, 0);

    private final List<LineSegment> lineSegmentList = new ArrayList<>();

    public void drawNextLineTo(String direction, long steps) {
        switch (direction) {
            case "U":
                var newCoordinateUp = new Coordinate(currentCoordinate.x(), currentCoordinate.y() - steps);
                lineSegmentList.add(new LineSegment(currentCoordinate, newCoordinateUp));
                currentCoordinate = newCoordinateUp;
                break;
            case "D":
                var newCoordinateDown = new Coordinate(currentCoordinate.x(), currentCoordinate.y() + steps);
                lineSegmentList.add(new LineSegment(currentCoordinate, newCoordinateDown));
                currentCoordinate = newCoordinateDown;
                break;
            case "L":
                var newCoordinateLeft = new Coordinate(currentCoordinate.x() - steps, currentCoordinate.y());
                lineSegmentList.add(new LineSegment(currentCoordinate, newCoordinateLeft));
                currentCoordinate = newCoordinateLeft;
                break;
            case "R":
                var newCoordinateRight = new Coordinate(currentCoordinate.x() + steps, currentCoordinate.y());
                lineSegmentList.add(new LineSegment(currentCoordinate, newCoordinateRight));
                currentCoordinate = newCoordinateRight;
                break;
            default:
                throw new RuntimeException("Unknown direction: " + direction);
        }
    }

    public List<LineSegment> getAllLineSegments() {
        return lineSegmentList;
    }
}
