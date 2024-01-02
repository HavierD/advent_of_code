package days.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternFinder {

    private List<Integer> stack = new ArrayList<>();
    private Map<Integer, List<Integer>> memory = new HashMap<>();
    private long counter = 0L;
    private Map<Integer, List<Integer>> gap1 = new HashMap<>();


    public void addValue(int value) {
        stack.add(value);
        if (!memory.containsKey(value)) {
            var list = new ArrayList<Integer>();
            list.add((int) counter);
            memory.put(value, list);
        } else {
            memory.get(value).add((int) counter);
        }
        counter++;

    }

    public void analyze() {
        for (var entry : memory.entrySet()) {
            var number = entry.getKey();
            var values = entry.getValue();
            var gapList = new ArrayList<Integer>();
            for (var i = 1; i < values.size(); i++) {
                var diff = values.get(i) - values.get(i - 1);
                gapList.add(diff);
            }
            if (!gapList.isEmpty()) {
                gap1.put(number, gapList);
            }
        }

        System.out.println("final 18:");
        for( var i = stack.size() - 18; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }

//        printResult();

    }

    private void printResult() {
        for (var entry : gap1.entrySet()) {
            var number = entry.getKey();
            var values = entry.getValue();
            System.out.println("number: " + number);
            System.out.print("gaps: ");
            for (var value : values) {
                System.out.print(value + " ");
            }
        }
    }
}
