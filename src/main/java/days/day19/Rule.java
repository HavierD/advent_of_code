package days.day19;

public class Rule {

    private String comparedFeature;
    private boolean isGreater;
    private int comparedValue;
    private final String destinationName;
    private boolean isDestinationOnly;


    public Rule(String comparedFeature, boolean isGreater, int comparedValue, String destinationName) {
        this.comparedFeature = comparedFeature;
        this.isGreater = isGreater;
        this.comparedValue = comparedValue;
        this.destinationName = destinationName;
    }

    public Rule(String destinationOnly) {
        this.destinationName = destinationOnly;
        this.isDestinationOnly = true;
    }

    public boolean check(Part part) {
        if (isDestinationOnly) {
            return true;
        }

        if (isGreater) {
            return part.getValueByFeature(comparedFeature) > comparedValue;
        }

        return part.getValueByFeature(comparedFeature) < comparedValue;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public boolean isDestinationOnly() {
        return isDestinationOnly;
    }

    public boolean isGreater() {
        return isGreater;
    }

    public int getComparedValue() {
        return comparedValue;
    }

    public boolean obeyTheRule(String feature, int value) {
        if (!feature.equals(comparedFeature)) {
            return true;
        }
        if (isGreater) {
            return value > comparedValue;
        }
        return value < comparedValue;
    }

    public String getComparedFeature() {
        return comparedFeature;
    }
}
