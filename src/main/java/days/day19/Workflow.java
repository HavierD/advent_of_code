package days.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Workflow {


    private String name;
    private List<Rule> rules = new ArrayList<>();

    public Workflow(String name, String rulesStr) {
        this.name = name;
        var rules = rulesStr.split(",");

        for (var rule : rules) {
            if (rule.contains(">")) {
                var isgreater = true;
                var comparedFeature = rule.split(">")[0];
                var comparedValue = Integer.parseInt(getSubstringBetween(rule, ">", ":"));
                var destinationName = rule.split(":")[1];
                this.rules.add(new Rule(comparedFeature, isgreater, comparedValue, destinationName));
            } else if (rule.contains("<")) {
                var isgreater = false;
                var comparedFeature = rule.split("<")[0];
                var comparedValue = Integer.parseInt(getSubstringBetween(rule, "<", ":"));
                var destinationName = rule.split(":")[1];
                this.rules.add(new Rule(comparedFeature, isgreater, comparedValue, destinationName));
            } else {
                this.rules.add(new Rule(rule));
            }
        }

    }

    public String getName() {
        return name;
    }

    public static String getSubstringBetween(String input, String startStr, String endStr) {
        int start = input.indexOf(startStr);
        if (start == -1) {
            throw new IllegalArgumentException("Start string not found");
        }
        start += startStr.length();

        int end = input.indexOf(endStr, start);
        if (end == -1) {
            throw new IllegalArgumentException("Start string not found");
        }

        return input.substring(start, end);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public List<Rule> getRulesBefore(String desName) {
        var index = -1;

        for (var i = 0; i < rules.size(); i++) {
            if (rules.get(i).getDestinationName().equals(desName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new RuntimeException("QQQ");
        }

        var returnRules = new ArrayList<>(rules);
        var toRemove = new ArrayList<Rule>();


        if (index + 1 < rules.size()) {

            for (var i = index + 1; i < rules.size(); i++) {
                toRemove.add(rules.get(i));
            }
        }
        returnRules.removeAll(toRemove);
        return returnRules;
    }
}
