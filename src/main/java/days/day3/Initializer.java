package days.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializer {
    private Map map;
    private final List<Number> numberSet = new ArrayList<>();
    private final List<Gear> gearSet = new ArrayList<>();

    public Initializer(String input) {
        map = new Map(input);

        var lines = map.getLines();
        for (var line : lines) {
            var changedLine = line.getLine().trim().replaceAll("[^\\d]", " ");
            var numbersArray = changedLine.trim().split("\\s+");
            var numbers = Arrays.stream(numbersArray).filter(s -> !s.isEmpty()).toArray(String[]::new);
            for (var number : numbers) {
                int startIndex = changedLine.indexOf(number);
                if (startIndex == -1) {
                    throw new RuntimeException("Something went wrong");
                }
                var n = new Number();
                n.setStartX(startIndex + 1);
                n.setEndX(startIndex + number.length());
                n.setY(line.getY());
                n.setValue(Integer.parseInt(number));
                numberSet.add(n);
                changedLine = changedLine.replaceFirst(number, " ".repeat(number.length()));
            }
        }

        numberSet.forEach(number -> number.validate(map));

        this.gearSet.addAll(map.getGears());
        this.gearSet.forEach(gear -> gear.validate(numberSet));

    }

    public static void main(String[] args) {
        var line = "      123     456";
        var changedLine = line.replaceAll("[^\\d]", " ");
        var numbers = changedLine.split("\\s+");
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public List<Number> getNumberSet() {
        return numberSet;
    }

    public List<Gear> getGearSet() {
        return gearSet;
    }
}
