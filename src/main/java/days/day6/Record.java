package days.day6;

public class Record {
    private Long time;
    private Long distance;
    private Long methodCount;

    public Record(Long time, Long distance) {
        this.time = time;
        this.distance = distance;
    }

    public void addOneMethod() {
        methodCount++;
    }

    public Long getTime() {
        return time;
    }

    public Long getDistance() {
        return distance;
    }

    public Long getMethodCount() {
        return methodCount;
    }
}
