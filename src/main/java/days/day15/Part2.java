package days.day15;

import java.util.ArrayList;
import java.util.List;

import static days.day15.Part1.calculate;

public class Part2 {

    private static List<Box> boxes = new ArrayList<>();

    public static void main(String[] args) {

        var inputs = new Input().input.split(",");

        for (var i = 0; i < 256; i++) {
            boxes.add(new Box(i));
        }

        for (var input : inputs) {
            var pairs = input.split("[-=]");
            var label = pairs[0];
            var boxNumber = hash(label);
            var box = getBoxBy(boxNumber);
            if (input.contains("-")) {
                box.removeLens(label);
            } else if (input.contains("=")) {
                int focalLength = Integer.parseInt(pairs[1].trim());
                box.addLens(new Lens(label, focalLength));
            }
        }
        var sum = 0L;
        for (var box : boxes) {
            sum += box.getAllPowers();
        }

        System.out.println(sum);

    }



    private static int hash(String value) {
        var chars = value.toCharArray();

        var currentValue = 0;
        for (char c : chars) {
            currentValue += c;
            currentValue = currentValue * 17;
            currentValue = currentValue % 256;
        }
        return currentValue;
    }

    private static Box getBoxBy(int boxNumber) {
        for (var box : boxes) {
            if (box.getNumber() == boxNumber) {
                return box;
            }
        }
        throw new RuntimeException("Box not found");
    }
}
