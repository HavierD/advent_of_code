package days.day18;

public class Command {

    private String direction;
    private int steps;
    private String color;

    public Command(String direction, int steps, String color) {
        this.direction = direction;
        this.steps = steps;
        this.color = color;
    }

    public String getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }

    public String getColor() {
        return color;
    }
}
