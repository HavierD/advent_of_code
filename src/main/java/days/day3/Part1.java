package days.day3;

public class Part1 {

    private static int sum = 0;
    public static void main(String[] args) {

        var set = new Initializer(Input.input);
        var numbers = set.getNumberSet();

        numbers.stream().filter(Number::isValid).forEach(number -> addValue(number.getValue()));

        System.out.println(sum);
    }

    private static void addValue(int value) {
        sum += value;
    }
}
