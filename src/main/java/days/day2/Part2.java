package days.day2;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static final List<String> games = List.of(Input.input.split("\n"));
    private static final List<Game> gameSet = new ArrayList<>();


    public static void main(String[] args) {
        initGameSet();
        var powerSum = 0;
        for (var game : gameSet) {
            powerSum += game.getGamePower();
        }
        System.out.println(powerSum);
    }

    private static void initGameSet() {
        games.forEach(gameInfo -> gameSet.add(new Game(gameInfo)));
    }
}
