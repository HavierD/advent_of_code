package days.day3;

public class Part2 {


    private static int sum = 0;

    public static void main(String[] args) {

        var set = new Initializer(Input.input);
        var numbers = set.getNumberSet();

        var gears = set.getGearSet();

        gears
                .stream()
                .filter(Gear::isValid)
                .peek(Gear::calculateRatio)
                .forEach(Part2::addValue);

        System.out.println(sum);
    }

    private static void addValue(Gear gear) {
        sum += gear.getGearRatio();
    }
}
