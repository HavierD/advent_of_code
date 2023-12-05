package days.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds = new ArrayList<>();
    private int gameId;

    public Game(String gameInfo) {
        var gameId = gameInfo.split(":")[0].replaceAll("Game ", "");
        this.gameId = Integer.parseInt(gameId);
        var infos = List.of(gameInfo.split(":")[1].split(";"));
        infos.forEach(this::setGameInfo);
    }

    private void setGameInfo(String info) {
        this.rounds.add(new Round(info));
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int getGameId() {
        return gameId;
    }

    public boolean isOverTotalBlue(int totalBlue) {
        for (var round : rounds) {
            if (round.getBlueCubeCount() > totalBlue) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverTotalRed(int totalRed) {
        for (var round : rounds) {
            if (round.getRedCubeCount() > totalRed) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverTotalGreen(int totalGreen) {
        for (var round : rounds) {
            if (round.getGreenCubeCount() > totalGreen) {
                return true;
            }
        }
        return false;
    }

    private int getFewestBlueCubeCount() {
        var fewestBlueCubeCount = 0;
        for (var round : rounds) {
            if (round.getBlueCubeCount() > fewestBlueCubeCount) {
                fewestBlueCubeCount = round.getBlueCubeCount();
            }
        }
        return fewestBlueCubeCount;
    }

    private int getFewestRedCubeCount() {
        var fewestRedCubeCount = 0;
        for (var round : rounds) {
            if (round.getRedCubeCount() > fewestRedCubeCount) {
                fewestRedCubeCount = round.getRedCubeCount();
            }
        }
        return fewestRedCubeCount;
    }

    private int getFewestGreenCubeCount() {
        var fewestGreenCubeCount = 0;
        for (var round : rounds) {
            if (round.getGreenCubeCount() > fewestGreenCubeCount) {
                fewestGreenCubeCount = round.getGreenCubeCount();
            }
        }
        return fewestGreenCubeCount;
    }

    public int getGamePower () {
        return getFewestBlueCubeCount() * getFewestRedCubeCount() * getFewestGreenCubeCount();
    }
}
