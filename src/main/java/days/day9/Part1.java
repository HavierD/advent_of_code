package days.day9;

import java.util.ArrayList;
import java.util.List;

public class Part1 {


    private static final List<Line> lines = new ArrayList<>();
    private static final List<Long> predictions = new ArrayList<>();

    public static void main(String[] args) {

        var inputs = new Input().input.split("\n");

        for (var input : inputs) {
            var values = new ArrayList<Long>();
            for (var value : input.split(" ")) {
                values.add(Long.parseLong(value));
            }
            var line = new Line();
            line.setValues(values);
            lines.add(line);
        }

        for (var line : lines) {
            var activeLine = line;

            // generate sublines
            while (!activeLine.isFlat()) {
                var subline = generateSubLineFor(activeLine);
                subline.setSuperLine(activeLine);
                activeLine.setSubline(subline);
                activeLine = subline;
            }

            // calculate from the bottom to the top
            while (activeLine.getSuperLine() != null) {
                var difference = activeLine.getFinalValue();
                var superLine = activeLine.getSuperLine();
                superLine.addValue(superLine.getFinalValue() + difference);
                activeLine = superLine;
            }

            predictions.add(activeLine.getFinalValue());

        }

        var result = 0;
        for (var p : predictions) {
            result += p;
        }
        System.out.println(result);

    }

    private static Line generateSubLineFor(Line activeLine) {
        var values = activeLine.getValues();
        var newLine = new Line();
        for (var i = 1; i < values.size(); i++) {
            var difference = values.get(i) - values.get(i - 1);
            newLine.addValue(difference);
        }
        return newLine;
    }
}
