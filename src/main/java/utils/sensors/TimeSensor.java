package utils.sensors;

import java.time.LocalDateTime;
import java.util.Timer;

public class TimeSensor {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    private int millisecond = 0;

    private static TimeSensor instance;

    private TimeSensor(){}

    public static TimeSensor getInstance(){
        if(instance == null){
            instance = new TimeSensor();
        }
        return instance;
    }

    public String currentTime() {
        return LocalDateTime.now().toString();
    }

    public void startTiming() {

        var timer = new Timer();




    }

    public static void main(String[] args) {

    }

}
