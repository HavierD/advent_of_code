package days.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Digger {

    private int currentX = 0;
    private int currentY = 0;
    private final List<Point> map = new ArrayList<>();



    public Digger() {
        map.add(new Point(0, 0));
    }

    public void dig(int steps, String direction) {

        switch (direction) {
            case "R":
                for (var x = currentX + 1; x <= currentX + steps; x++) {
                    if (getPointByCoordinate(x, currentY) == null) {
                        map.add(new Point(x, currentY, true));
                    }
                }
                currentX = currentX + steps;
                break;
            case "L":
                for (var x = currentX - 1; x >= currentX - steps; x--) {
                    if (getPointByCoordinate(x, currentY) == null) {
                        map.add(new Point(x, currentY, true));
                    }
                }
                currentX = currentX - steps;
                break;
            case "U":
                for (var y = currentY - 1; y >= currentY - steps; y--) {
                    if (getPointByCoordinate(currentX, y) == null) {
                        map.add(new Point(currentX, y, true));
                    }
                }
                currentY = currentY - steps;
                break;
            case "D":
                for (var y = currentY + 1; y <= currentY + steps; y++) {
                    if (getPointByCoordinate(currentX, y) == null) {
                        map.add(new Point(currentX, y, true));
                    }
                }
                currentY = currentY + steps;
                break;
        }


    }

    public List<Point> getMap() {
        return map;
    }

    public static void main(String[] args) {
//        String input = "..###..#..#.###.#";
//        Pattern pattern = Pattern.compile("(?<!#)#(?!#)");
//        Matcher matcher = pattern.matcher(input);
//        int count = 0;
//        while (matcher.find()) {
//            count++;
//        }
//        System.out.println("Count of single # is: " + count);


        String input = "..#..#..#.#.#";
        Pattern pattern = Pattern.compile("##+");
        Matcher matcher = pattern.matcher(input);
        boolean containsMultipleHashes = matcher.find();
        System.out.println("Contains multiple #?: " + containsMultipleHashes);
    }

    private Point getPointByCoordinate(int x, int y) {
        for (var point : map) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        return null;
    }
}
