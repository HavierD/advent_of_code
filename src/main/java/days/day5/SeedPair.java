package days.day5;

public class SeedPair {
    private final Long seedNumber;
    private final Long range;

    public SeedPair(Long seedNumber, Long range) {
        this.seedNumber = seedNumber;
        this.range = range;
    }

    public Long getSeedNumber() {
        return seedNumber;
    }


    public Long getRange() {
        return range;
    }
}
