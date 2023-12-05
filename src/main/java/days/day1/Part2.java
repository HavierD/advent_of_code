package days.day1;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static final List<String> inputs = List.of(Input.input.split("\n"));
    private static final List<String> testInputs = List.of(Input.testInput.split("\n"));

    public static void main(String[] args) {

        var converter = new Converter();
        var sum = 0;
        List<String> convertedLines = new ArrayList<>();

        for (var line : inputs) {
//        for (var line : testInputs) {
            var halfConvertedLine = converter.convertFirstStringNumFromTheEnd(line);
            var convertedLine = converter.convertFirstStringNumFromTheBeginning(halfConvertedLine);
            convertedLines.add(convertedLine);
            List<String> digitOnly = List.of(convertedLine.replaceAll("[^\\d]", "").split(""));
            String numberString = digitOnly.get(0) + digitOnly.get(digitOnly.size() - 1);
            int number = Integer.parseInt(numberString);
            sum += number;
            System.out.println();
        }

        convertedLines.forEach(System.out::println);
        System.out.println(sum);

    }



}
