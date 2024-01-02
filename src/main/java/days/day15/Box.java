package days.day15;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private int number;
    private List<Lens> lenses = new ArrayList<>();

    public Box(int number) {
        this.number = number;
    }

    public void addLens(Lens lens) {
        var index = findLensIndexBy(lens.getLabel());
        if (index == -1) {
            lenses.add(lens);
            return;
        }
        lenses.set(index, lens);
    }

    private int findLensIndexBy(String label) {
        for (var lens : lenses) {
            if (lens.getLabel().equals(label)) {
                return lenses.indexOf(lens);
            }
        }
        return -1;
    }

    public boolean removeLens(String lensLabel) {
        for (var lens : lenses) {
            if (lens.getLabel().equals(lensLabel)) {
                lenses.remove(lens);
                return true;
            }
        }
        return false;
    }

    public int getNumber() {
        return number;
    }

    public long getAllPowers() {
        var sum = 0L;
        for (var lens : lenses) {
            sum += lens.getFocusingPower(number, lenses.indexOf(lens) + 1);
        }
        return sum;
    }
}
