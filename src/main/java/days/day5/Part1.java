package days.day5;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {


        var locations = new ArrayList<Long>();

        var seeds = new ArrayList<>(List.of(Input.seeds.split(" ")));
        var seedToSoil = new Mapping(NodeEnum.SEED, NodeEnum.SOIL, Input.seedToSoil);
        var soilToFertilizer = new Mapping(NodeEnum.SOIL, NodeEnum.FERTILIZER, Input.soilToFertilizer);
        var fertilizerToWater = new Mapping(NodeEnum.FERTILIZER, NodeEnum.WATER, Input.fertilizerToWater);
        var waterToLight = new Mapping(NodeEnum.WATER, NodeEnum.LIGHT, Input.waterToLight);
        var lightToTemperature = new Mapping(NodeEnum.LIGHT, NodeEnum.TEMPERATURE, Input.lightToTemperature);
        var temperatureToHumidity = new Mapping(NodeEnum.TEMPERATURE, NodeEnum.HUMIDITY, Input.temperatureToHumidity);
        var humidityToLocation = new Mapping(NodeEnum.HUMIDITY, NodeEnum.LOCATION, Input.humidityToLocation);

//        var seeds = new ArrayList<>(List.of(TestInput.seeds.split(" ")));
//        var seedToSoil = new Mapping(NodeEnum.SEED, NodeEnum.SOIL, TestInput.seedToSoil);
//        var soilToFertilizer = new Mapping(NodeEnum.SOIL, NodeEnum.FERTILIZER, TestInput.soilToFertilizer);
//        var fertilizerToWater = new Mapping(NodeEnum.FERTILIZER, NodeEnum.WATER, TestInput.fertilizerToWater);
//        var waterToLight = new Mapping(NodeEnum.WATER, NodeEnum.LIGHT, TestInput.waterToLight);
//        var lightToTemperature = new Mapping(NodeEnum.LIGHT, NodeEnum.TEMPERATURE, TestInput.lightToTemperature);
//        var temperatureToHumidity = new Mapping(NodeEnum.TEMPERATURE, NodeEnum.HUMIDITY, TestInput.temperatureToHumidity);
//        var humidityToLocation = new Mapping(NodeEnum.HUMIDITY, NodeEnum.LOCATION, TestInput.humidityToLocation);

        for (var seed : seeds) {
            var seedNumber = Long.parseLong(seed);

            var soilNumber = seedToSoil.walkToDestination(seedNumber);

            var fertilizerNumber = soilToFertilizer.walkToDestination(soilNumber);

            var waterNumber = fertilizerToWater.walkToDestination(fertilizerNumber);

            var lightNumber = waterToLight.walkToDestination(waterNumber);

            var temperatureNumber = lightToTemperature.walkToDestination(lightNumber);

            var humidityNumber = temperatureToHumidity.walkToDestination(temperatureNumber);

            var locationNumber = humidityToLocation.walkToDestination(humidityNumber);
            if (locationNumber == 3374647) {
                System.out.println();
            }
            locations.add(locationNumber);
        }

        System.out.println(findSmallestNumber(locations));

    }

    public static Long findSmallestNumber(List<Long> numbers) {
        var smallest = Long.MAX_VALUE;
        for (var number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }
}
