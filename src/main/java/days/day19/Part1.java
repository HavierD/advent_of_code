package days.day19;


import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<Workflow> workflows = new ArrayList<>();
    private static List<Part> parts = new ArrayList<>();

    public static void main(String[] args) {

        var in = new Input().input;
        var workFlowStr = in.split("\n\n")[0];
        var partsStr = in.split("\n\n")[1];

        var workStrs = workFlowStr.split("\n");
        var partStrs = partsStr.split("\n");

        for (var workStr : workStrs) {
            var name = workStr.split("\\{")[0];
            var rulesStr = Workflow.getSubstringBetween(workStr, "{", "}");
            var workflow = new Workflow(name, rulesStr);
            workflows.add(workflow);
        }

        for (var partStr : partStrs) {
            var x = Integer.parseInt(Workflow.getSubstringBetween(partStr, "x=", ","));
            var m = Integer.parseInt(Workflow.getSubstringBetween(partStr, "m=", ","));
            var a = Integer.parseInt(Workflow.getSubstringBetween(partStr, "a=", ","));
            var s = Integer.parseInt(Workflow.getSubstringBetween(partStr, "s=", "}"));
            var part = new Part(x, m, a, s);
            parts.add(part);
        }


        for (var part : parts) {
            var destination = "in";
            while (true) {
                destination = part.getDestinationFromTestingBy(getWorkflowByName(destination));
                if (destination.equals("A")) {
                    part.setAccepted(true);
                    break;
                }
                if (destination.equals("R")) {
                    part.setAccepted(false);
                    break;
                }
            }
        }

        var sum = 0;
        for (var part : parts) {
            if (part.isAccepted()) {
                sum += part.getTotalValue();
            }
        }
        System.out.println("sum = " + sum);
    }

    private static Workflow getWorkflowByName(String name) {
        for (var workflow : workflows) {
            if (workflow.getName().equals(name)) {
                return workflow;
            }
        }
        throw new IllegalArgumentException("Workflow not found");
    }
}
