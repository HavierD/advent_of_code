package days.day11;

public class Star {

    private Long x;
    private Long y;

    private Long enlargeXTimes = 0L;
    private Long enlargeYTimes = 0L;

    public Star(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }


    public Long getY() {
        return y;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public void enlargex1Time() {
        enlargeXTimes++;
    }

    public void enlargey1Time() {
        enlargeYTimes++;
    }

    public void enlarge(Long rate) {
        x = x + enlargeXTimes * rate;
        y = y + enlargeYTimes * rate;
    }
}
