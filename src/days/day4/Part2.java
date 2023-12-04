package days.day4;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static final List<String> inputs = List.of(Input.input.split("\n"));
    private static final List<Card> cardSet = new ArrayList<>();

    public static void main(String[] args) {

        initCardSet();
        for (var i = 0; i < cardSet.size(); i++) {
            var checkedCard = cardSet.get(i);
            var matchedCount = checkedCard.getMatchedCount();
            for (var j = 1; j <= matchedCount; j++) {
                findCard(i + 1 + j).addCopies(checkedCard.getCardCount());
            }
        }
        System.out.println(getTotalCardCount());


    }

    private static void initCardSet() {
        for (var input : inputs) {
            cardSet.add(new Card(input));
        }
    }

    private static Card findCard(int cardNumber) {
        for (var card : cardSet) {
            if (card.getCardNumber() == cardNumber) {
                return card;
            }
        }
        throw new RuntimeException("Card not found");
    }

    private static int getTotalCardCount() {
        var totalCardCount = 0;
        for (var card : cardSet) {
            totalCardCount += card.getCardCount();
        }
        return totalCardCount;
    }
}
