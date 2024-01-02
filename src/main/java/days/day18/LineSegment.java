package days.day18;

public class LineSegment implements Lineable {

    private Coordinate startCoordinate;
    private Coordinate endCoordinate;
    private boolean isVertical;

    //form is z or c
    private boolean isZForm;

    public LineSegment(Coordinate startCoordinate, Coordinate endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        if (startCoordinate.x() == endCoordinate.x()) {
            isVertical = true;
            if (endCoordinate.y() > startCoordinate.y()) {
            }
        } else if (startCoordinate.y() == endCoordinate.y()) {
            isVertical = false;
        } else {
            throw new RuntimeException("LineSegment must be either vertical or horizontal");
        }
    }

    // get min x
    public long getMinX() {
        return Math.min(startCoordinate.x(), endCoordinate.x());
    }

    // get max x
    public long getMaxX() {
        return Math.max(startCoordinate.x(), endCoordinate.x());
    }

    // get min y
    public long getMinY() {
        if (isVertical) {
            return Math.min(startCoordinate.y(), endCoordinate.y()) + 1;

        }
        return Math.min(startCoordinate.y(), endCoordinate.y());
    }

    // get max y
    public long getMaxY() {
        if (isVertical) {
            return Math.max(startCoordinate.y(), endCoordinate.y()) - 1;
        }
        return Math.max(startCoordinate.y(), endCoordinate.y());
    }

    public boolean isVertical() {
        return isVertical;
    }

    // get covered count (including start and excluding end)
    public long getCoveredCount() {
        if (isVertical) {
            return Math.abs(startCoordinate.y() - endCoordinate.y());
        } else {
            return Math.abs(startCoordinate.x() - endCoordinate.x());
        }
    }

    public boolean isZForm() {
        return isZForm;
    }

    public void setZForm(boolean ZForm) {
        isZForm = ZForm;
    }

    public CrossingType getCrossingType(long y) {

        if (y < getMinY() || y > getMaxY()) {
            return CrossingType.NO_CROSSING;
        }

        if (isVertical) {
            return CrossingType.DIRECT_CROSSING;
        }

        if (isZForm) {
            return CrossingType.THROUGH_AND_CROSSING;
        }

        return CrossingType.THROUGH_BUT_NO_CROSSING;

    }

    public long getFirstOverlapX(long y) {
        if (isVertical) {
            return startCoordinate.x();
        }
        return getMinX();
    }
}
