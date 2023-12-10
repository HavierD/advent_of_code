package days.day10;

public class Part1 {


    private static Map map;
    public static void main(String[] args) {


        map = new Map(new Input().input);

        System.out.println("Farthest distance: " + map.findFarthestDistance());


    }
}
