package days.day12;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) {

        var lines = new Input().input.split("\n");
        for (var line : lines) {
            var infoPair = line.split(" ");
            assert infoPair.length == 2;
            var countStr = List.of(infoPair[1].split(","));
            var count = new ArrayList<Integer>();
            for (var str : countStr) {
                count.add(Integer.parseInt(str));
            }
            pairs.add(new Pair(infoPair[0], count));
        }

        var sum = 0;
        for (var pair : pairs) {
//            sum += pair.countArrangements();
        }

        System.out.println(sum);
    }
}
