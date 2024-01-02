package days.day19;

import java.util.ArrayList;
import java.util.List;

public class Part2 {


    private static List<Workflow> workflows = new ArrayList<>();

    private static List<Part> parts = new ArrayList<>();

    private static long duplicatePossibilities = 0;


    private static List<ScopeAnalyser> analysers = new ArrayList<ScopeAnalyser>();

    public static void main(String[] args) {


        var in = new Input().testInput;
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

        // init end

        var desName = "A";
        analyse(desName);



    }

    private static void analyse(String desName) {
        var containA = getWorkflowsWhoseRolesContain(desName);
        for (var wf : containA) {
            var analyser = new ScopeAnalyser();
            var validRules = wf.getRulesBefore(desName);
            analyser.narrowDownScopeAccordingTo(validRules);
            var nextDestinations = getWorkflowsWhoseRolesContain(wf.getName());
            for (var workFlow : nextDestinations) {
                analyse(workFlow.getName());
            }
            addNewAnalyser(analyser);
        }
    }

    private static void addNewAnalyser(ScopeAnalyser analyser) {
        calculateDuplicatePossibilities(analyser);
        analysers.add(analyser);
    }

    private static void calculateDuplicatePossibilities(ScopeAnalyser analyser) {
        

        for (var existingAnalyser : analysers) {
        }
    }

    private static List<Workflow> getWorkflowsWhoseRolesContain(String destinationName) {

        List<Workflow> result = new ArrayList<>();

        for (var wf : workflows) {
            for (var r : wf.getRules()) {
                if (r.getDestinationName().equals(destinationName)) {
                    result.add(wf);
                    break;
                }
            }
        }

        return result;
    }
}
