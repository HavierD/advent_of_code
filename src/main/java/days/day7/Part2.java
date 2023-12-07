package days.day7;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static final List<Hand2> HAND2s = new ArrayList<>();
    public static void main(String[] args) {

        var lines = new Input().input.split("\n");
        for (var line : lines) {
            var words = line.split(" ");
            HAND2s.add(new Hand2(words[0], Long.parseLong(words[1])));
        }

        HAND2s.sort(Hand2::compare);
        for (var i = 1; i <= HAND2s.size(); i++) {
            HAND2s.get(i - 1).setRank((long) i);
        }

        Long sum = 0L;
        for (var hand : HAND2s) {
            sum += hand.getRank() * hand.getBid();
        }

        System.out.println(sum);


    }
}
