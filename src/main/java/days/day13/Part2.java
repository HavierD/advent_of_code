package days.day13;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static List<BlockWithSmudge> blocks = new ArrayList<>();


    public static void main(String[] args) {

        var input = new Input().input;
        var blocksInfo = input.split("\n\n");
        for (String blockInfo : blocksInfo) {
            blocks.add(new BlockWithSmudge(blockInfo));
        }

        var sum = 0;
        for (BlockWithSmudge block : blocks) {
            sum += block.getOutput();
        }

        System.out.println(sum);

    }
}
