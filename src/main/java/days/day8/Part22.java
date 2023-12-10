package days.day8;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part22 {

    private static Map<String, String> networksLeft = new HashMap<>();
    private static Map<String, String> networksRight = new HashMap<>();

    private static Long stepCount = 0L;

    private static List<String> currentNetworks;

    private static Instructor instructor;

    public static void main(String[] args) {


        var lines = new Input().input.split("\n");
        instructor = new Instructor(new Input().instruction);


        for (var line : lines) {
            var parts = line.split("=");
            var name = parts[0].trim();

            var infoString = parts[1].replaceAll("[^a-zA-Z0-9]", " ").trim();
            var infos = infoString.split(" +");

            var left = infos[0].trim();
            var right = infos[1].trim();
            networksLeft.put(name, left);
            networksRight.put(name, right);
        }

        currentNetworks = findBeginningNetworks();

        while (true) {

            if (stepCount % 14363 == 0) {
                System.out.println();
            }

            if (stepCount == 394561955) {
                System.out.println();
            }

            if (stepCount % 5000000 == 0) {
                DecimalFormat format = new DecimalFormat("#,####");
                var formated = format.format(stepCount);
                System.out.println("Step count: " + formated);
            }

            var ins = instructor.getNextInstruction();
            if (ins.equals("L")) {
                currentNetworks = goToLeftTogether(currentNetworks);
            } else if (ins.equals("R")) {
                currentNetworks = goToRightTogether(currentNetworks);
            } else {
                throw new RuntimeException("Unknown instruction");
            }
            stepCount++;
            var zCount = 0;
            for (var network : currentNetworks) {
                if (!network.endsWith("Z")) {
                    break;
                }
                zCount++;
            }
            if (zCount > 3) {
                System.out.println("z already has: " + zCount + "!");
            }

            if (zCount == currentNetworks.size()) {
                System.out.println("Reached ZZZ in " + stepCount + " steps");
                break;
            } else if (zCount > currentNetworks.size()) {
                throw new RuntimeException("Too many Zs");
            }
        }




    }

    private static List<String> goToLeftTogether(List<String> currentNetworks) {
        var nextNetworks = new ArrayList<String>();
        for (var currentNetwork : currentNetworks) {
            var nextNetwork = networksLeft.get(currentNetwork);
            nextNetworks.add(nextNetwork);
        }
        return nextNetworks;
    }

    private static List<String> goToRightTogether(List<String> currentNetworks) {
        var nextNetworks = new ArrayList<String>();
        for (var currentNetwork : currentNetworks) {
            var nextNetwork = networksRight.get(currentNetwork);
            nextNetworks.add(nextNetwork);
        }
        return nextNetworks;
    }



    public static List<String> findBeginningNetworks() {
        var beginningNetworks = new ArrayList<String>();
        for (String network : networksLeft.keySet()) {
            if (network.endsWith("A")) {
                beginningNetworks.add(network);
            }
        }
        return beginningNetworks;
    }

}
