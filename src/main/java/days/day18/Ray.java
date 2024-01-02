package days.day18;

public class Ray implements Lineable{

    // y = ax + b
    private double a;
    private double b;

    private Coordinate startPoint;
    private Coordinate passPoint;

    public Ray(Coordinate startPoint, Coordinate passPoint) {
        this.startPoint = startPoint;
        this.passPoint = passPoint;
        if (startPoint.x() == passPoint.x()) {
            throw new RuntimeException("Ray must not be vertical");
        } else if (startPoint.y() == passPoint.y()) {
            throw new RuntimeException("Ray must not be horizontal");
        }else {
            a = (double) (passPoint.y() - startPoint.y()) / (passPoint.x() - startPoint.x());
            b = startPoint.y() - a * startPoint.x();
        }
    }

    public boolean isCrossing(LineSegment lineSegment) {
        if (lineSegment.isVertical()) {
            var x = lineSegment.getMaxX();
            var y = a * x + b;
            return y >= lineSegment.getMinY() && y <= lineSegment.getMaxY();
        }
        // or is horizontal
        var y = lineSegment.getMaxY();
        var x = (y - b) / a;
        return x >= lineSegment.getMinX() && x <= lineSegment.getMaxX();
    }

}
