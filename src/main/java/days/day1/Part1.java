package days.day1;

import java.util.List;

public class Part1 {

    private static List<String> inputs = List.of(Input.input.split("\n"));

    public static void main(String[] args) {

        int sum = 0;
        for (var line : inputs) {
            List<String> digitOnly = List.of(line.replaceAll("[^\\d]", "").split(""));
            String numberString = digitOnly.get(0) + digitOnly.get(digitOnly.size() - 1);
            int number = Integer.parseInt(numberString);
            sum += number;
        }

        System.out.println(sum);


    }
}
