package days.day8;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<Network> networks = new ArrayList<>();

    private static int stepCount = 0;

    private static Network currentNetwork;

    private static Instructor instructor;

    public static void main(String[] args) {

        var lines = new Input().input.split("\n");
        instructor = new Instructor(new Input().instruction);

        for (var line : lines) {
            var parts = line.split("=");
            var name = parts[0].trim();

            //replace all ( and ) with empty string for infos
            var infoString = parts[1].replaceAll("[^a-zA-Z]", " ").trim();
            var infos = infoString.split(" +");


//            var infos = parts[1].replaceAll("(", "").replaceAll(")", "").split(",");
            var left = infos[0].trim();
            var right = infos[1].trim();
            networks.add(new Network(name, left, right));
        }



        currentNetwork = findNetworkByName("AAA");

        while(true) {
            var ins = instructor.getNextInstruction();
            if (ins.equals("L")) {
                currentNetwork = goToLeft(currentNetwork);
            } else if (ins.equals("R")) {
                currentNetwork = goToRight(currentNetwork);
            } else {
                throw new RuntimeException("Unknown instruction");
            }
            stepCount++;
            if (currentNetwork.getName().equals("ZZZ")) {
                System.out.println("Reached ZZZ in " + stepCount + " steps");
                break;
            }
        }




    }



    private static Network goToRight(Network currentNetwork) {
        var nextNetwork = findNetworkByName(currentNetwork.getRight());
        return nextNetwork;
    }

    public static Network goToLeft(Network currentNetwork) {
        var nextNetwork = findNetworkByName(currentNetwork.getLeft());
        return nextNetwork;
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
