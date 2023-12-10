package days.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    
    private Line subline;
    
    private Line superLine;

    
    private List<Long> values = new ArrayList<>();

    public void setValues(List<Long> values) {
        this.values = values;
    }

    public boolean isFlat() {
        var firstValue = values.get(0);
        for (var v : values) {
            if (!Objects.equals(v, firstValue)) {
                return  false;
            }
        }
        return true;
    }

    public List<Long> getValues() {
        return values;
    }

    // add one value
    public void addValue(Long value) {
        values.add(value);
    }

    public void setSubline(Line subline) {
        this.subline = subline;
    }

    public void setSuperLine(Line superLine) {
        this.superLine = superLine;
    }

    public Line getSuperLine() {
        return superLine;
    }

    //get final value
    public Long getFinalValue() {
        return values.get(values.size() - 1);
    }

    // get first value
    public Long getFirstValue() {
        return values.get(0);
    }

    // insert value to the left
    public void insertValueToLeft(Long value) {
        values.add(0, value);
    }


}
