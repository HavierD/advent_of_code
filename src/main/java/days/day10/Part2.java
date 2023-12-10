package days.day10;

import java.util.List;

public class Part2 {

    private static Map map;
    public static void main(String[] args) {


        map = new Map(new Input().input);

        var loop = map.getLoopPoints();
        var scanner = new Scanner(map.getMaxX(), map.getMaxY(), loop, map);
        scanner.scan();

        System.out.println(scanner.getInsideCount());

    }


}
