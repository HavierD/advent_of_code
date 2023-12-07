package days.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand1 {
    private List<String> cards;
    private Long bid;
    private Long rank;
    private List<Integer> mark = new ArrayList<>();
    private TypeEnum type;


    public Hand1(String cardString, Long bid) {
        mark.add(0);
        mark.add(0);
        mark.add(0);
        mark.add(0);
        mark.add(0);

        this.cards = List.of(cardString.split(""));
        this.bid = bid;
        mark();
    }

    private void mark() {
        this.type = TypeAnalyzer.analyze(cards);
        markCards();
    }

    private void markCards() {
        for (var i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals("A")) {
                mark.set(i, 14);
                continue;
            }
            if (cards.get(i).equals("K")) {
                mark.set(i, 13);
                continue;
            }
            if (cards.get(i).equals("Q")) {
                mark.set(i, 12);
                continue;
            }
            if (cards.get(i).equals("J")) {
                mark.set(i, 11);
                continue;
            }
            if (cards.get(i).equals("T")) {
                mark.set(i, 10);
                continue;
            }
            mark.set(i, Integer.parseInt(cards.get(i)));
        }
    }

    public int compare(Hand1 other) {
        if (this.type.value > other.type.value) {
            return 1;
        }
        if (this.type.value < other.type.value) {
            return -1;
        }
        for (var i = 0; i < this.mark.size(); i++) {
            if (Objects.equals(this.mark.get(i), other.mark.get(i))) {
                continue;
            }
            if (this.mark.get(i) > other.mark.get(i)) {
                return 1;
            }
            if (this.mark.get(i) < other.mark.get(i)) {
                return -1;
            }
        }
        throw new RuntimeException("compare error!");
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getBid() {
        return bid;
    }
}
