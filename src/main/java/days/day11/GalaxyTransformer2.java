package days.day11;

import java.util.ArrayList;
import java.util.List;

public class GalaxyTransformer2 {

    private final List<Star> stars = new ArrayList<>();
    private Long maxX;
    private Long maxY;

    private Long rate;


    public GalaxyTransformer2(String mapText, Long rate) {
        this.rate = rate;
        var lines = mapText.split("\n");
        for (var y = 0; y < lines.length; y++) {
            var points = lines[y].split("");
            for (var x = 0; x < points.length; x++) {
                if (points[x].equals("#")) {
                    stars.add(new Star((long) x, (long)y));
                }
            }
        }
        setMaxXY();
    }

    private void setMaxXY() {
        maxX = 0L;
        maxY = 0L;
        for (var star : stars) {
            if (star.getX() > maxX) {
                maxX = star.getX();
            }
            if (star.getY() > maxY) {
                maxY = star.getY();
            }
        }
    }

    public void transform() {
        for (var x = 0; x <= maxX; x++) {
            if (noStarInX(x)) {
                largerStarsXOnTheRight(x);
            }
        }
        for (var y = 0; y <= maxY; y++) {
            if (noStarInY(y)) {
                largerStarsYOnTheBottom(y);
            }
        }

        for (var star : stars) {
            star.enlarge(rate);
        }
    }
    private void largerStarsXOnTheRight(int x) {
        for (var star : stars) {
            if (star.getX() > x) {
                star.enlargex1Time();
            }
        }

    }
    private void largerStarsYOnTheBottom(int y) {
        for (var star : stars) {
            if (star.getY() > y) {
                star.enlargey1Time();
            }
        }
    }



    private boolean noStarInX(int x) {
        for (var star : stars) {
            if (star.getX() == x) {
                return false;
            }
        }
        return true;
    }

    private boolean noStarInY(int y) {
        for (var star : stars) {
            if (star.getY() == y) {
                return false;
            }
        }
        return true;
    }


    public List<Star> getStars() {
        return stars;
    }
}
