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
        return source + range >= from && from >= source;
    }

    public Long walkToDestination(Long from) {
        return from - source + destination;
    }
}
