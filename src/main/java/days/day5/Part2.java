package days.day5;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static Long min = Long.MAX_VALUE;
    private static Long howManySeeds = 0L;

    public static void main(String[] args) {

        var seeds = new ArrayList<>(List.of(Input.seeds.split(" ")));
        var seedPairs = new ArrayList<SeedPair>();
        for (var i = 1; i <= seeds.size(); i+=2) {
            var seedNumber = Long.parseLong(seeds.get(i - 1));
            var seedRange = Long.parseLong(seeds.get(i));
            seedPairs.add(new SeedPair(seedNumber, seedRange));
        }
        var seedToSoil = new Mapping(NodeEnum.SEED, NodeEnum.SOIL, Input.seedToSoil);
        var soilToFertilizer = new Mapping(NodeEnum.SOIL, NodeEnum.FERTILIZER, Input.soilToFertilizer);
        var fertilizerToWater = new Mapping(NodeEnum.FERTILIZER, NodeEnum.WATER, Input.fertilizerToWater);
        var waterToLight = new Mapping(NodeEnum.WATER, NodeEnum.LIGHT, Input.waterToLight);
        var lightToTemperature = new Mapping(NodeEnum.LIGHT, NodeEnum.TEMPERATURE, Input.lightToTemperature);
        var temperatureToHumidity = new Mapping(NodeEnum.TEMPERATURE, NodeEnum.HUMIDITY, Input.temperatureToHumidity);
        var humidityToLocation = new Mapping(NodeEnum.HUMIDITY, NodeEnum.LOCATION, Input.humidityToLocation);




        for (var seedPair : seedPairs) {
            System.out.println("seedPair: " + seedPair.getSeedNumber());
            for (var number = seedPair.getSeedNumber(); number < seedPair.getSeedNumber() + seedPair.getRange(); number++) {
                var soilNumber = seedToSoil.walkToDestination(number);
                var fertilizerNumber = soilToFertilizer.walkToDestination(soilNumber);
                var waterNumber = fertilizerToWater.walkToDestination(fertilizerNumber);
                var lightNumber = waterToLight.walkToDestination(waterNumber);
                var temperatureNumber = lightToTemperature.walkToDestination(lightNumber);
                var humidityNumber = temperatureToHumidity.walkToDestination(temperatureNumber);
                var locationNumber = humidityToLocation.walkToDestination(humidityNumber);
                howManySeeds++;
                if (locationNumber < min) {
                    System.out.println(" a new location is lower than current min:" + locationNumber + " < " + min);
                    System.out.println("from number: " + number);
                    min = locationNumber;
                }
            }
        }

        System.out.println("howManySeeds: " + howManySeeds);
        System.out.println(min);



    }
}
