package days.day5;

public class TestInput {
    public static final String seeds = "79 14 55 13";
    public static final String seedToSoil =
            "50 98 2\n" +
            "52 50 48";

    public static final String soilToFertilizer =
            "0 15 37\n" +
            "37 52 2\n" +
            "39 0 15";

    // the rest as this : seeds: 79 14 55 13
    //
    //seed-to-soil map:
    //50 98 2
    //52 50 48
    //
    //soil-to-fertilizer map:
    //0 15 37
    //37 52 2
    //39 0 15
    //
    //fertilizer-to-water map:
    //49 53 8
    //0 11 42
    //42 0 7
    //57 7 4
    //
    //water-to-light map:
    //88 18 7
    //18 25 70
    //
    //light-to-temperature map:
    //45 77 23
    //81 45 19
    //68 64 13
    //
    //temperature-to-humidity map:
    //0 69 1
    //1 0 69
    //
    //humidity-to-location map:
    //60 56 37
    //56 93 4

    public static final String fertilizerToWater =
            "49 53 8\n" +
            "0 11 42\n" +
            "42 0 7\n" +
            "57 7 4";

    public static final String waterToLight =
            "88 18 7\n" +
            "18 25 70";

    public static final String lightToTemperature =
            "45 77 23\n" +
            "81 45 19\n" +
            "68 64 13";

    public static final String temperatureToHumidity =
            "0 69 1\n" +
            "1 0 69";

    public static final String humidityToLocation =
            "60 56 37\n" +
            "56 93 4";
}
