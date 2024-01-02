package days.day11;

public class Part2 {

    public static void main(String[] args) {

        var in = new Input().input;
        var rate = new Input().rate - 1;

        var galaxyTransformer = new GalaxyTransformer2(in, rate);

        galaxyTransformer.transform();

        var stars = galaxyTransformer.getStars();

        var sum = 0L;
        var pairCount = 0;
        for (var i = 0; i < stars.size(); i++) {
            var currentStar = stars.get(i);
            for (var j = i + 1; j < stars.size(); j++) {
                var otherStar = stars.get(j);
                var distance = calculateDistanceBetween(currentStar, otherStar);
                var currentStr = "("+currentStar.getX()+","+currentStar.getY()+")";
                var otherStr = "("+otherStar.getX()+","+otherStar.getY()+")";
//                System.out.println("distance between " + currentStr + " and " + otherStr + " is " + distance + " steps");
                pairCount++;
                sum += distance;
            }
        }

        System.out.println("pairCount: " + pairCount);
        System.out.println(sum);


    }

    private static Long calculateDistanceBetween(Star currentStar, Star otherStar) {
        var x1 = currentStar.getX();
        var y1 = currentStar.getY();
        var x2 = otherStar.getX();
        var y2 = otherStar.getY();
        var xDistance = Math.max(x1, x2) - Math.min(x1, x2);
        var yDistance = Math.max(y1, y2) - Math.min(y1, y2);
        return xDistance + yDistance;
    }
}
