package days.day12;

import java.util.ArrayList;
import java.util.List;

public class Part2 {


    private static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) {


        var sum = 0L;
        var lines = new Input().input.split("\n");
        for (var line : lines) {

            var infoPair = line.split(" ");
            assert infoPair.length == 2;
            var countStr = new ArrayList<>(List.of(infoPair[1].split(",")));
            var copy = new ArrayList<>(countStr);
            countStr.addAll(copy);
            countStr.addAll(copy);
            countStr.addAll(copy);
            countStr.addAll(copy);
            var count = new ArrayList<Integer>();
            for (var str : countStr) {
                count.add(Integer.parseInt(str));
            }
            var infoBuilder = new StringBuilder();
            for (var i = 0; i < 5; i++) {
                infoBuilder.append(infoPair[0]);
                if (i != 4) {
                    infoBuilder.append("?");
                }
            }
            var pair = new Pair(infoBuilder.toString(), count);
            sum += pair.getArrangementCount();
        }


        System.out.println("sum = " + sum);
    }
}
