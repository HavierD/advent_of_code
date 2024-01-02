package days.day14;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private List<Snapshot> records = new ArrayList<>();

    public void checkSnapshot(Snapshot snapshot) {
        if (records.contains(snapshot)) {
            System.out.println("Found");
            System.out.println(snapshot);
            System.out.println(records.indexOf(snapshot));
            System.exit(0);
        } else {
            records.add(snapshot);
        }
    }


}
