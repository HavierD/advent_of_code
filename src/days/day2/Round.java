package days.day2;

import java.util.List;

public class Round {
    private int blueCubeCount = 0;
    private int redCubeCount = 0;
    private int greenCubeCount = 0;

    public Round(String roundInfo) {
        var infos = List.of(roundInfo.split(","));
        infos.forEach(this::setRoundInfo);

    }

    private void setRoundInfo(String info) {
        if (info.contains("blue")) {
            var numberStr = info.replaceAll(" ", "").replaceAll("blue", "");
            this.blueCubeCount = Integer.parseInt(numberStr);
            return;
        }
        if (info.contains("red")) {
            var numberStr = info.replaceAll(" ", "").replaceAll("red", "");
            this.redCubeCount = Integer.parseInt(numberStr);
            return;
        }
        if (info.contains("green")) {
            var numberStr = info.replaceAll(" ", "").replaceAll("green", "");
            this.greenCubeCount = Integer.parseInt(numberStr);
        }
    }
}
