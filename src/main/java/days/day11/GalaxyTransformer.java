package days.day11;

import java.util.ArrayList;
import java.util.List;

public class GalaxyTransformer {

    private final List<Point> map = new ArrayList<>();
    private int maxX;
    private int maxY;
    private String mapStr;

    private Long rate;

    public GalaxyTransformer(String mapText) {
        formMap(mapText);
    }

    private void formMap(String mapText) {
        mapStr = mapText;
        map.clear();
        var lines = mapText.split("\n");
        this.maxY = lines.length;
        for (var y = 0; y < lines.length; y++) {
            var line = lines[y];
            var points = line.split("");
            this.maxX = points.length;
            for (var x = 0; x < points.length; x++) {
                var point = points[x];
//                map.add(new Point(x, y, point));
            }
        }

        System.out.println();
    }

    public void transformVertically() {
        var columns = getAllColumns();
        var newColumns = new ArrayList<String>();
        for (var x = 0; x < maxX; x++) {
            newColumns.add(columns.get(x));
            if (columns.get(x).contains("#")) {
                continue;
            }
            newColumns.add( columns.get(x));
        }
        var mapStr = new StringBuilder();
        for (var y = 0; y < newColumns.get(0).length(); y++) {
            for (var x = 0; x < newColumns.size(); x++) {
                try {
                    mapStr.append(newColumns.get(x).charAt(y));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            mapStr.append("\n");
        }
        formMap(mapStr.toString());
    }

    public void transformHorizontally() {
        var rows = getAllRows();
        var newRows = new ArrayList<String>();
        for (var i = 0; i < rows.size(); i++) {
            newRows.add(rows.get(i));
            if (rows.get(i).contains("#")) {
                continue;
            }
            newRows.add(rows.get(i));
        }
        var mapStr = new StringBuilder();
        for (var row : newRows) {
            mapStr.append(row).append("\n");
        }
        formMap(mapStr.toString());
    }

    private List<String> getAllColumns() {
        var columns = new ArrayList<String>();
        for (var x = 0; x < maxX; x++) {
            var column = new StringBuilder();
            for (var y = 0; y < maxY; y++) {
                var point = findPointByCoordinates(x, y);
                column.append(point.isStar() ? "#" : ".");
            }
            columns.add(column.toString());
        }
        return columns;
    }

    private List<String> getAllRows() {
        var rows = new ArrayList<String>();
        for (var y = 0; y < maxY; y++) {
            var row = new StringBuilder();
            for (var x = 0; x < maxX; x++) {
                var point = findPointByCoordinates(x, y);
                row.append(point.isStar() ? "#" : ".");
            }
            rows.add(row.toString());
        }
        return rows;
    }


    public static void main(String[] args) {
        var r = "123456";
        var r2 = "234567";
        var r3 = "345678";

        var rs = new ArrayList<String>();
        rs.add(r);
        rs.add(r2);
        rs.add(r3);

        rs.add(2, r2);


        System.out.println(rs);

    }

    private Point findPointByCoordinates(int x, int y) {
        for (var point : map) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        throw new IllegalArgumentException("No point found with coordinates: " + x + ", " + y);
    }

    public List<Point> getAllStars() {
        var stars = new ArrayList<Point>();
        for (var point : map) {
            if (point.isStar()) {
                stars.add(point);
            }
        }
        return stars;
    }
}
