package days.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScopeAnalyser {

    private Rectangle4Dimension rectangle;
    public ScopeAnalyser() {

        rectangle = new Rectangle4Dimension(1, 4000, 1, 4000, 1, 4000, 1, 4000);

    }


    public long getPossibilities() {
        // todo
    }


    public void narrowDownScopeAccordingTo(List<Rule> validRules) {

        for (var rule : validRules) {
            if (rule.isDestinationOnly()) {
                continue;
            }
            if (rule.isGreater()) {
                switch (rule.getComparedFeature()) {
                    case "x":
                        if (rule.isGreater()) {
                            rectangle.setMinX(rule.getComparedValue() + 1);
                        } else {
                            rectangle.setMaxX(rule.getComparedValue() - 1);
                        }
                        break;
                    case "m":
                        if (rule.isGreater()) {
                            rectangle.setMinM(rule.getComparedValue() + 1);
                        } else {
                            rectangle.setMaxM(rule.getComparedValue() - 1);
                        }
                        break;
                    case "a":
                        if (rule.isGreater()) {
                            rectangle.setMinA(rule.getComparedValue() + 1);
                        } else {
                            rectangle.setMaxA(rule.getComparedValue() - 1);
                        }
                        break;
                    case "s":
                        if (rule.isGreater()) {
                            rectangle.setMinS(rule.getComparedValue() + 1);
                        } else {
                            rectangle.setMaxS(rule.getComparedValue() - 1);
                        }
                        break;
                }
            }
        }

    }
}
