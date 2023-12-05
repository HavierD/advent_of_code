package days.day5;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {

        var seeds = new ArrayList<>(List.of(TestInput.seeds.split(" ")));
        var locations = new ArrayList<Long>();

//        var seedToSoil = new Mapping(NodeEnum.SEED, NodeEnum.SOIL, Input.seedToSoil);
//        var soilToFertilizer = new Mapping(NodeEnum.SOIL, NodeEnum.FERTILIZER, Input.soilToFertilizer);
//        var fertilizerToWater = new Mapping(NodeEnum.FERTILIZER, NodeEnum.WATER, Input.fertilizerToWater);
//        var waterToLight = new Mapping(NodeEnum.WATER, NodeEnum.LIGHT, Input.waterToLight);
//        var lightToTemperature = new Mapping(NodeEnum.LIGHT, NodeEnum.TEMPERATURE, Input.lightToTemperature);
//        var temperatureToHumidity = new Mapping(NodeEnum.TEMPERATURE, NodeEnum.HUMIDITY, Input.temperatureToHumidity);
//        var humidityToLocation = new Mapping(NodeEnum.HUMIDITY, NodeEnum.LOCATION, Input.humidityToLocation);

        var seedToSoil = new Mapping(NodeEnum.SEED, NodeEnum.SOIL, TestInput.seedToSoil);
        var soilToFertilizer = new Mapping(NodeEnum.SOIL, NodeEnum.FERTILIZER, TestInput.soilToFertilizer);
        var fertilizerToWater = new Mapping(NodeEnum.FERTILIZER, NodeEnum.WATER, TestInput.fertilizerToWater);
        var waterToLight = new Mapping(NodeEnum.WATER, NodeEnum.LIGHT, TestInput.waterToLight);
        var lightToTemperature = new Mapping(NodeEnum.LIGHT, NodeEnum.TEMPERATURE, TestInput.lightToTemperature);
        var temperatureToHumidity = new Mapping(NodeEnum.TEMPERATURE, NodeEnum.HUMIDITY, TestInput.temperatureToHumidity);
        var humidityToLocation = new Mapping(NodeEnum.HUMIDITY, NodeEnum.LOCATION, TestInput.humidityToLocation);

        for (var seed : seeds) {
            var seedNumber = Long.parseLong(seed);
            System.out.println("seedNumber: " + seedNumber);
            var soilNumber = seedToSoil.walkToDestination(seedNumber);
            System.out.println("soilNumber: " + soilNumber);
            var fertilizerNumber = soilToFertilizer.walkToDestination(soilNumber);
            System.out.println("fertilizerNumber: " + fertilizerNumber);
            var waterNumber = fertilizerToWater.walkToDestination(fertilizerNumber);
            System.out.println("waterNumber: " + waterNumber);
            var lightNumber = waterToLight.walkToDestination(waterNumber);
            System.out.println("lightNumber: " + lightNumber);
            var temperatureNumber = lightToTemperature.walkToDestination(lightNumber);
            System.out.println("temperatureNumber: " + temperatureNumber);
            var humidityNumber = temperatureToHumidity.walkToDestination(temperatureNumber);
            System.out.println("humidityNumber: " + humidityNumber);
            var locationNumber = humidityToLocation.walkToDestination(humidityNumber);
            System.out.println("locationNumber: " + locationNumber);
            locations.add(locationNumber);
        }

        System.out.println(findSmallestNumber(locations));

    }

    private static Long findSmallestNumber(List<Long> numbers) {
        var smallest = Long.MAX_VALUE;
        for (var number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }
}
