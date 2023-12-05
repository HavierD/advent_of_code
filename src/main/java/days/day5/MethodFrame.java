package days.day5;

public class MethodFrame {
    private final Long destination;
    private final Long source;
    private final Long range;

    public MethodFrame(Long destination, Long source, Long range) {
        this.destination = destination;
        this.source = source;
        this.range = range;
    }

    public boolean includes(Long from) {
        var max = source + range;
        var min = source;
        return from >= min && from < max;
    }

    public Long walkToDestination(Long from) {
        var a = from - source + destination;
        if (a < 0) {
            throw new RuntimeException("a < 0");
        }
        return from - source + destination;
    }
}
