package days.day7;

import java.util.ArrayList;
import java.util.List;

public class Part1 {


    private static final List<Hand1> HAND_1s = new ArrayList<>();
    public static void main(String[] args) {

        var lines = new Input().input.split("\n");
        for (var line : lines) {
            var words = line.split(" ");
            HAND_1s.add(new Hand1(words[0], Long.parseLong(words[1])));
        }

        HAND_1s.sort(Hand1::compare);
        for (var i = 1; i <= HAND_1s.size(); i++) {
            HAND_1s.get(i - 1).setRank((long) i);
        }

        Long sum = 0L;
        for (var hand : HAND_1s) {
            sum += hand.getRank() * hand.getBid();
        }

        System.out.println(sum);


    }
}
