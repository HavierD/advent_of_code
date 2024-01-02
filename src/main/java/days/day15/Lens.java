package days.day15;

public class Lens {
    private String label;
    private int focalLength;

    private static long biggestPower = 0L;

    public Lens(String label, int focalLength) {
        this.label = label;
        this.focalLength = focalLength;
    }

    public int getHash() {
        var chars = label.toCharArray();

        var currentValue = 0;
        for (char c : chars) {
            currentValue += c;
            currentValue = currentValue * 17;
            currentValue = currentValue % 256;
        }
        return currentValue;
    }

    public String getLabel() {
        return label;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public long getFocusingPower(int boxNumber, int slotNumger) {
        var first = 1 + boxNumber;
        var second = slotNumger;
        var third = focalLength;
        var result = first * second * third;
        if (result > biggestPower) {
            biggestPower = result;
            System.out.println("New biggest power: " + biggestPower);
        }
        return result;
    }
}
