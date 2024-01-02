package days.day13;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<Block> blocks = new ArrayList<>();


    public static void main(String[] args) {

        var input = new Input().input;
        var blocksInfo = input.split("\n\n");
        for (String blockInfo : blocksInfo) {
            blocks.add(new Block(blockInfo));
        }

        var sum = 0;
        blocks.forEach(Block::checkRowMirrors);
        blocks.forEach(Block::checkColumnMirrors);
        for (Block block : blocks) {
            sum += block.getOutput();
        }

        System.out.println(sum);

    }
}
