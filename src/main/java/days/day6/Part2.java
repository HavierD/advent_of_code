package days.day6;

public class Part2 {

    static Long sum = 0L;
    static Record record;
    public static void main(String[] args) {

        init();
        for (var i = 0; i < record.getTime(); i++) {

            var duration = record.getTime();
            var runningTime = duration - i;
            var currentDistance = runningTime * i;
            if (currentDistance > record.getDistance()) {
                sum = sum + 1;
            }
        }

        System.out.println(sum);



    }

    private static void init() {
        var in = new Input();

        var timeStr = in.time.replaceAll(" ", "");
        var time = Long.parseLong(timeStr);
        var distanceStr = in.distance.replaceAll(" ", "");
        var distance = Long.parseLong(distanceStr);
        record  = new Record(time, distance);

    }
}
