package days.day13;

import java.util.ArrayList;
import java.util.List;

public class BlockWithSmudge {
    private ArrayList<String> lines = new ArrayList<>();
    private Integer newNumber;
    private Boolean isNewNumberRow;
    private Integer oldNumber;
    private Boolean isOldNumberRow;
    private String block;

    public BlockWithSmudge(String block) {

        this.block = block;
//        lines = (ArrayList<String>) List.of(block.split("\n"));
        lines.addAll(List.of(block.split("\n")));
        checkRowMirrors();
        checkColumnMirrors();
        this.oldNumber = newNumber;
        this.isOldNumberRow = isNewNumberRow;
        newNumber = null;
        isNewNumberRow = null;
        fixSmudge();
    }

    private void fixSmudge() {
        for (var x = 0; x < lines.get(0).length(); x++) {
            for (var y = 0; y < lines.size(); y++) {
                var backupLine = lines.get(y);
                if (lines.get(y).charAt(x) == '.') {
                    lines.set(y, replaceCharAt(lines.get(y), x, '#'));
                } else if (lines.get(y).charAt(x) == '#') {
                    lines.set(y, replaceCharAt(lines.get(y), x, '.'));
                } else {
                    throw new RuntimeException("Invalid character");
                }
                if (hasNewMirror()) {
                    return;
                }
                lines.set(y, backupLine);
            }
        }
        System.out.println();
    }

    private boolean hasNewMirror() {
        newNumber = null;
        isNewNumberRow = null;
            checkRowMirrors();
        if (newNumber != null) {
            if (!newNumber.equals(oldNumber) || !isNewNumberRow.equals(isOldNumberRow)) {
                return true;
            }
            newNumber = null;
            isNewNumberRow = null;
        }
            checkColumnMirrors();
        if (newNumber != null) {
            if (!newNumber.equals(oldNumber) || !isNewNumberRow.equals(isOldNumberRow)) {
                return true;
            }
            newNumber = null;
            isNewNumberRow = null;
        }

        return false;
    }

    private String replaceCharAt(String str, int index, char ch) {
        if (index < 0 || index >= str.length()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return new String(chars);
    }

    public List<String> getLines() {
        return lines;
    }

    //get columns
    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        for (int i = 0; i < lines.get(0).length(); i++) {
            StringBuilder column = new StringBuilder();
            for (String line : lines) {
                try {
                    column.append(line.charAt(i));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            columns.add(column.toString());
        }
        return columns;
    }

    public void checkRowMirrors() {
        var numberList = new ArrayList<Integer>();
        for (int i = 1; i < lines.size(); i++) {
            var hasMirror = true;
            for (int j = 1; j <= Math.min(i, lines.size() - i); j++) {
                var line1 = lines.get(i - j);
                var line2 = lines.get(i + j - 1);
                if (!line1.equals(line2)) {
                    hasMirror = false;
                    break;
                }
            }
            if (hasMirror) {
                numberList.add(i);
            }
        }
        if (isOldNumberRow!= null && isOldNumberRow ) {
            if (numberList.contains(oldNumber)) {
                numberList.remove(oldNumber);
            }
        }
        if (numberList.size() > 1) {
            throw new IndexOutOfBoundsException("More than one mirror");
        }
        if (!numberList.isEmpty()) {
            isNewNumberRow = true;
            newNumber = numberList.get(0);
        }
    }

    public void checkColumnMirrors() {
        var numberList = new ArrayList<Integer>();
        var columns = getColumns();
        for (int i = 1; i < columns.size(); i++) {
            var hasMirror = true;
            for (int j = 1; j <= Math.min(i, columns.size() - i); j++) {
                if (!columns.get(i - j).equals(columns.get(i + j - 1))) {
                    hasMirror = false;
                    break;
                }
            }
            if (hasMirror) {
                numberList.add(i);
            }
        }
        if (isOldNumberRow != null && !isOldNumberRow ) {
            if (numberList.contains(oldNumber)) {
                numberList.remove(oldNumber);
            }
        }
        if (numberList.size() > 1) {
            throw new IndexOutOfBoundsException("More than one mirror");
        }
        if (!numberList.isEmpty()) {
            isNewNumberRow = false;
            newNumber = numberList.get(0);
        }
    }

    public int getOutput() {
        if (newNumber == null) {
            throw new RuntimeException("No mirror");
        }
        if (isNewNumberRow) {
            return newNumber * 100;
        } else {
            return newNumber;
        }
    }
}
