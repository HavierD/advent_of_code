package days.day2;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    private static final List<String> games = List.of(Input.input.split("\n"));
    private static final List<Game> gameSet = new ArrayList<>();
    private static final int totalBlue = 14;
    private static final int totalRed = 12;
    private static final int totalGreen = 13;

    public static void main(String[] args) {
        initGameSet();
        var sum = 0;

        for (var game : gameSet) {
            if (game.isOverTotalBlue(totalBlue)) {
                continue;
            }
            if (game.isOverTotalRed(totalRed)) {
                continue;
            }
            if (game.isOverTotalGreen(totalGreen)) {
                continue;
            }
            sum += game.getGameId();
        }

        System.out.println(sum);
    }

    private static void initGameSet() {
        games.forEach(gameInfo -> gameSet.add(new Game(gameInfo)));
    }
}
