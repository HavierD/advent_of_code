package days.day8;

import java.util.ArrayList;
import java.util.List;


public class Part2 {

    private static List<Network> networks = new ArrayList<>();

    private static Long stepCount = 0L;

    private static List<Network> currentNetworks;

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
            networks.add(new Network(name, left, right));
        }

        currentNetworks = findBeginningNetworks();

        while (true) {

            if (stepCount % 1000000 == 0) {
                System.out.println("Step count: " + stepCount);
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
                if (!network.getName().endsWith("Z")) {
                    break;
                }
                zCount++;
            }
            if (zCount > 2) {
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

    private static List<Network> goToLeftTogether(List<Network> currentNetworks) {
        var nextNetworks = new ArrayList<Network>();
        for (var network : currentNetworks) {
            var nextNetwork = findNetworkByName(network.getLeft());
            nextNetworks.add(nextNetwork);
        }
        return nextNetworks;
    }

    private static List<Network> goToRightTogether(List<Network> currentNetworks) {
        var nextNetworks = new ArrayList<Network>();
        for (var network : currentNetworks) {
            var nextNetwork = findNetworkByName(network.getRight());
            nextNetworks.add(nextNetwork);
        }
        return nextNetworks;
    }



    public static List<Network> findBeginningNetworks() {
        var beginningNetworks = new ArrayList<Network>();
        for (var network : networks) {
            if (network.getName().endsWith("A")) {
                beginningNetworks.add(network);
            }
        }
        return beginningNetworks;
    }

    public static Network findNetworkByName(String name) {
        for (var network : networks) {
            if (network.getName().equals(name)) {
                return network;
            }
        }
        throw new RuntimeException("Network not found");
    }
}
