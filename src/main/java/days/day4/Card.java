package days.day4;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private int cardNumber = 0;
    private final List<Integer> winningNumbers = new ArrayList<>();
    private final List<Integer> haveNumbers = new ArrayList<>();
    private int cardCount = 1;

    public Card(String string) {
        var numbers = string.split(":")[1].split("\\|");
        var winningNumbers = numbers[0].trim().split("\\s+");
        var haveNumbers = numbers[1].trim().split("\\s+");
        for (var winningNumber : winningNumbers) {
            this.winningNumbers.add(Integer.parseInt(winningNumber));
        }
        for (var haveNumber : haveNumbers) {
            this.haveNumbers.add(Integer.parseInt(haveNumber));
        }

        // for part 2:
        String numberStr = string.split(":")[0].replaceAll("Card", "").replaceAll(" ", "");
        this.cardNumber = Integer.parseInt(numberStr);
    }

    public List<Integer> getHaveNumbers() {
        return haveNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void addCopies(int copies) {
        this.cardCount += copies;
    }

    public int mark() {
        var count = getMatchedCount();
        if (count == 0) {
            return 0;
        }
        if (count == 1) {
            return 1;
        }
        return (int) Math.pow(2, count - 1);
    }

    public int getMatchedCount() {
        var count = 0;
        for (var winningNumber : winningNumbers) {
            if (haveNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {


    }


    public int getCardCount() {
        return cardCount;
    }
}
