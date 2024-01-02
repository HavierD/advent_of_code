package days.day19;

public class Rectangle4Dimension {
    private int minX;
    private int maxX;
    private int minM;
    private int maxM;
    private int minA;
    private int maxA;
    private int minS;
    private int maxS;

    public Rectangle4Dimension(int minX, int maxX, int minM, int maxM, int minA, int maxA, int minS, int maxS) {
        this.minX = minX;
        this.maxX = maxX;
        this.minM = minM;
        this.maxM = maxM;
        this.minA = minA;
        this.maxA = maxA;
        this.minS = minS;
        this.maxS = maxS;
    }

    public long getSize() {
        var long1 = (long) (maxX - minX + 1) * (maxM - minM + 1);
        var long2 = long1 * (maxA - minA + 1);
        return long2 * ((long)(maxS - minS + 1));
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinM() {
        return minM;
    }

    public void setMinM(int minM) {
        this.minM = minM;
    }

    public int getMaxM() {
        return maxM;
    }

    public void setMaxM(int maxM) {
        this.maxM = maxM;
    }

    public int getMinA() {
        return minA;
    }

    public void setMinA(int minA) {
        this.minA = minA;
    }

    public int getMaxA() {
        return maxA;
    }

    public void setMaxA(int maxA) {
        this.maxA = maxA;
    }

    public int getMinS() {
        return minS;
    }

    public void setMinS(int minS) {
        this.minS = minS;
    }

    public int getMaxS() {
        return maxS;
    }

    public void setMaxS(int maxS) {
        this.maxS = maxS;
    }
}
