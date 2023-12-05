package days.day3;

public class Point {
    private int x;
    private int y;
    private int value = -1;
    private StatusEnum status;

    public Point(int x, int y, char status) {
        this.x = x;
        this.y = y;
        if (status == '.') {
            this.status = StatusEnum.EMPTY;
            return;
        }
        if (status == '*') {
            this.status = StatusEnum.GEAR;
            return;
        }
        if (Character.isDigit(status)) {
            this.status = StatusEnum.DIGIT;
            this.value = Character.getNumericValue(status);
            return;
        }
        this.status = StatusEnum.SYMBOL;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }
}
