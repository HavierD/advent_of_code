package days.day15;


public class Part1 {

    public static void main(String[] args) {
//        var value = new Input().testInput;
        var value = "qp=3";

//        calculate(value);


        var sum = 0;
        var inputs = new Input().input.split(",");
        for (var input : inputs) {
            sum += calculate(input);
        }

        System.out.println(sum);

    }

    public static int calculate(String value) {
        var chars = value.toCharArray();

        var currentValue = 0;
        for (char c : chars) {
            currentValue += c;
            currentValue = currentValue * 17;
            currentValue = currentValue % 256;
        }
        return currentValue;
    }
}
