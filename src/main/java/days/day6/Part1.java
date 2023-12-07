package days.day6;

import days.day5.Part2;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<Record> records = new ArrayList<>();
    private static Long sum = 1L;

    public static void main(String[] args) {

        init();

        for (var record : records) {
            for (var i = 0; i < record.getTime(); i++) {
                var duration = record.getTime();
                var runningTime = duration - i;
                var currentDistance = runningTime * i;
                if (currentDistance > record.getDistance()) {
                    record.addOneMethod();
                }
            }
        }



        records.forEach(r -> multiply(r.getMethodCount()));

        System.out.println(sum);

    }

    private static void init() {
        var in = new Input();

        var times = in.time.split(" ");
        var distances = in.distance.split(" ");

        for (var i = 0; i < times.length; i++) {
            records.add(new Record(Long.parseLong(times[i]), Long.parseLong(distances[i])));
        }
    }

    private static void multiply(Long number) {
        sum = sum * number;
    }
}
