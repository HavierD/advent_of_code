package days.day19;

public class Part {
    private int x;
    private int m;
    private int a;
    private int s;


    private Boolean isAccepted;

    public Part(int x, int m, int a, int s) {
        this.x = x;
        this.m = m;
        this.a = a;
        this.s = s;
    }

    public String getDestinationFromTestingBy(Workflow workflow) {
        var rules = workflow.getRules();
        String destination = "";

        for (var r : rules) {
            if (r.check(this)) {
                destination = r.getDestinationName();
                break;
            }
        }
        return destination;
    }

    public int getValueByFeature(String feature) {
        switch (feature) {
            case "x":
                return x;
            case "m":
                return m;
            case "a":
                return a;
            case "s":
                return s;
            default:
                throw new IllegalArgumentException("Feature not found");
        }
    }

    public Boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public int getTotalValue() {
        return x + m + a + s;
    }
}
