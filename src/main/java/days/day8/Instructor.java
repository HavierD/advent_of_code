package days.day8;

public class Instructor {
    private String[] instructions;
    private static int index = 0;

    public Instructor(String instructions) {
        this.instructions = instructions.split("");
    }

    public String getNextInstruction() {
        var ins = instructions[index];
        if (index == instructions.length - 1) {
            index = 0;
        } else {
            index++;
        }
        return ins;
    }

    public void returnToBeginning() {
        index = 0;
    }
}
