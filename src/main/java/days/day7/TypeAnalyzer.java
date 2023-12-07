package days.day7;

import java.util.ArrayList;
import java.util.List;

public class TypeAnalyzer {
    public static TypeEnum analyze(List<String> cards) {


        var highestOccurrence = 0;
        for (var compared : cards) {
            var occurrence = 0;
            for (var c : cards) {
                if (c.equals(compared)) {
                    occurrence++;
                }
            }
            if (highestOccurrence < occurrence) {
                highestOccurrence = occurrence;
            }
        }
        if (highestOccurrence == 5) {
            return TypeEnum.FIVE_OF_A_KIND;
        }

        if (highestOccurrence == 4) {
            return TypeEnum.FOUR_OF_A_KIND;
        }

        if (highestOccurrence == 3) {
            return tellThreeOccurrence(cards);
        }

        if (highestOccurrence == 2) {
            return tellTwoOccurrence(cards);
        }

        if (highestOccurrence == 1) {
            return TypeEnum.HIGH_CARD;
        }
        throw new RuntimeException("analyzing error!");
    }

    private static TypeEnum tellTwoOccurrence(List<String> cards) {
        var firstTwoOccurrenceCard = "";
        var possibleSecondOccurrenceCard = "";
        for (var c : cards) {
            var times = 0;
            for (var cc : cards) {
                if (c.equals(cc)) {
                    times++;
                }
            }
            if (times == 2) {
                if (firstTwoOccurrenceCard.isEmpty() || firstTwoOccurrenceCard.equals(c)) {
                    firstTwoOccurrenceCard = c;
                } else {
                    possibleSecondOccurrenceCard = c;
                }
            }
        }
        if (possibleSecondOccurrenceCard.isEmpty()) {
            return TypeEnum.ONE_PAIR;
        }
        return TypeEnum.TWO_PAIR;
    }

    private static TypeEnum tellThreeOccurrence(List<String> cards) {
        var threeOccurrenceCard = "";
        for (var c : cards) {
            var times = 0;
            for (var cc : cards) {
                if (c.equals(cc)) {
                    times++;
                }
            }
            if (times == 3 ) {
                threeOccurrenceCard = c;
                break;
            }
        }
        if (threeOccurrenceCard.isEmpty()) {
            throw new RuntimeException("tell three occurrence wrong");
        }
        var otherTwo = new ArrayList<String>();
        for (var c : cards) {
            if (c.equals(threeOccurrenceCard)) {
                continue;
            }
            otherTwo.add(c);
        }
        if (otherTwo.get(0).equals(otherTwo.get(1))) {
            return TypeEnum.FULL_HOUSE;
        }
        return TypeEnum.THREE_OF_A_KIND;
    }
}
