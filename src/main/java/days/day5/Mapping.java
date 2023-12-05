package days.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapping {
    public final NodeEnum source;
    public final NodeEnum destination;

    private List<MethodFrame> methodSet = new ArrayList<>();

    // key: source value: destination
//    private Map<Long, Long> mapMethods = new HashMap<>();


    public Mapping(NodeEnum source, NodeEnum destination, String mapInfo) {
        this.source = source;
        this.destination = destination;

        initMapMethods(mapInfo);
    }

    private void initMapMethods(String mapInfo) {

        var infos = mapInfo.split("\n");
        for (var info : infos) {
            var numbers = info.trim().split(" ");
            methodSet.add(new MethodFrame(
                    Long.parseLong(numbers[0]),
                    Long.parseLong(numbers[1]),
                    Long.parseLong(numbers[2])
            ));
        }
    }


    public Long walkToDestination(Long source) {
        for (var m : methodSet) {
            if (m.includes(source)) {
                return m.walkToDestination(source);
            }
        }
        return source;
    }



}
