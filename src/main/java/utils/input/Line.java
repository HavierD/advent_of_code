package utils.input;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<String> elements = new ArrayList<>();

    private Line(){}

    public static Line elementSeparatedBySpace(String lineString) {
        var line = new Line();
        var elements = lineString.split(" ");
        line.elements.addAll(List.of(elements));
        return line;
    }

    public static Line elementSeparatedByMultiSpace(String lineString) {
        var line = new Line();
        var elements = lineString.split(" +");
        line.elements.addAll(List.of(elements));
        return line;
    }

    public List<String> getElements() {
        return elements;
    }
}
