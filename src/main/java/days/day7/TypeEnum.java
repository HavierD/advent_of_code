package days.day7;

public enum TypeEnum {
    FIVE_OF_A_KIND(7L),
    FOUR_OF_A_KIND(6L),
    FULL_HOUSE(5L),
    THREE_OF_A_KIND(4L),
    TWO_PAIR(3L),
    ONE_PAIR(2L),
    HIGH_CARD(1L);

    public final Long value;

    TypeEnum(Long value) {
        this.value = value;
    }
}
