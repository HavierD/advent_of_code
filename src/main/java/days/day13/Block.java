package days.day13;

import java.util.ArrayList;
import java.util.List;

public class Block {

    private List<String> lines = new ArrayList<>();
    private List<Integer> rowsNumber = new ArrayList<>();
    private List<Integer> columnsNumber = new ArrayList<>();
    private String block;

    public Block(String block) {

        this.block = block;
        lines = List.of(block.split("\n"));

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
        for (int i = 1; i < lines.size(); i++) {
            var hasMirror = true;
            for (int j = 1; j <= Math.min(i, lines.size() - i); j++) {
                var line1 = lines.get(i - j);
                var line2 = lines.get(i + j - 1);
                if (!line1.equals(line2)) {
                    hasMirror = false;
                    break ;
                }
            }
            if (hasMirror) {
                rowsNumber.add(i);
            }
        }
    }

    public void checkColumnMirrors() {
        var columns = getColumns();
        for (int i = 1; i < columns.size(); i++) {
            var hasMirror = true;
            for (int j = 1; j <= Math.min(i, columns.size() - i); j++) {
                if (!columns.get(i - j).equals(columns.get(i + j - 1))) {
                    hasMirror = false;
                    break ;
                }
            }
            if (hasMirror) {
                columnsNumber.add(i);
            }
        }
    }

    public int getOutput() {
        if (rowsNumber.size() > 1 || columnsNumber.size() > 1) {
            throw new RuntimeException("More than one mirror");
        }
        var a = 0;
        var b = 0;
        if (!rowsNumber.isEmpty()) {
            a = rowsNumber.get(0) * 100;
        }
        if (!columnsNumber.isEmpty()) {
            b = columnsNumber.get(0);
        }
        return a + b;
    }
}
