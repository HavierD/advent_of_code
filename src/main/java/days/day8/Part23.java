package days.day8;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part23 {
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
        var numbers = new ArrayList<Long>();

        for (var network : currentNetworks) {

            int testCount = 0;
            String walkingNetwork = network;

            while (testCount < 100000) {
                var ins = instructor.getNextInstruction();
                if (ins.equals("L")) {
                    walkingNetwork = networksLeft.get(walkingNetwork);
                } else if (ins.equals("R")) {
                    walkingNetwork = networksRight.get(walkingNetwork);
                } else {
                    throw new RuntimeException("Unknown instruction");
                }
                testCount++;
                if (walkingNetwork.endsWith("Z")) {
                    numbers.add(stepCount);
                    break;
                }
            }
            instructor.returnToBeginning();
        }


        var numbersArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numbersArray[i] = Integer.parseInt(String.valueOf(numbers.get(i))) ;
        }



        var result = LCMCalculator.lcmOfArray(numbersArray);

//        BigInteger result = BigInteger.valueOf(1);
//        for (var number : numbers) {
//            result = BigInteger.valueOf(number).multiply(result);
//        }

        System.out.println(result);

//        System.out.println("first:" + result / numbers.get(0));
//        System.out.println("second:" + result / numbers.get(1));
//        System.out.println("third:" + result / numbers.get(2));
//        System.out.println("fourth:" + result / numbers.get(3));
//        System.out.println("fifth:" + result / numbers.get(4));
//        System.out.println("sixth:" + result / numbers.get(5));



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
