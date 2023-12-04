package days.day4;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    private static final List<String> inputs = List.of(Input.input.split("\n"));
    private static List<Card> cards = new ArrayList<>();

    public static void main(String[] args) {
        for (var input : inputs) {
            cards.add(new Card(input));
        }

        var score = 0;
        for (var card : cards) {
            score += card.mark();
        }

        System.out.println(score);

    }
}
