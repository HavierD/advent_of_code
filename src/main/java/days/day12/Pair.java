package days.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair {

    private String infoStr;
    private List<Integer> countSet = new ArrayList<>();
    private long arrangementCount = 0L;

    private List<Long> indexesOfQuestnMark;


    public Pair(String infoStr, List<Integer> countSet) {
        this.infoStr = infoStr;
        this.countSet = countSet;
//        count();
        count2();
    }

    private void count2() {
        generate("");
    }

    private void generate(String buildingString) {
        if ((buildingString.contains("#") && buildingString.endsWith(".")) || buildingString.length() == infoStr.length()) {
            var springs = Arrays.stream(buildingString.split("\\.+")).filter(s -> !s.isEmpty()).toArray(String[]::new);
            var canContinue = true;
            for (var i = 0; i < springs.length; i++) {

                try {
                    var test = countSet.get(i);
                } catch (IndexOutOfBoundsException e) {
                    return;
                }

                if (springs[i].length() != countSet.get(i)) {
                    canContinue = false;
                    break;
                }
            }
            if (!canContinue) {
                return;
            }
            if (buildingString.length() == infoStr.length()) {
                if (springs.length == countSet.size()) {
                    arrangementCount++;
                }
                return;
            }
        }


        var i = buildingString.length();
        String ch = null;
        try {
            ch = charFromInfo(i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (ch != null) {
            generate(buildingString + ch);
        } else {
            generate(buildingString + "#");
            generate(buildingString + ".");
        }
    }



    public void generateCombinations(String s, int length) {
        if (s.length() == length) {
            check(s);
            return;
        }

        generateCombinations(s + "#", length);
        generateCombinations(s + ".", length);
    }

    private String charFromInfo(int i) {
        char ch = 0;
        try {
            ch = infoStr.charAt(i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (ch == '?') {
            return null;
        }
        return String.valueOf(ch);
    }



    public void count() {
        indexesOfQuestnMark = findIndexesOfQuestnMark();
        var length = indexesOfQuestnMark.size();
        generateCombinations("", length);
    }

    public boolean matchesPattern(String str, List<Integer> counts) {
        var patternBuilder = new StringBuilder();
        patternBuilder.append("^\\.*");
        for (var i = 0; i < counts.size(); i++) {
            patternBuilder.append("#{" + counts.get(i) + ",}");
            if (i != counts.size() - 1) {
                patternBuilder.append("\\.+");
            }
        }
        patternBuilder.append("\\.*");
        patternBuilder.append("$");


//        String pattern = "^\\.*" + "#{" + x + ",}" + "\\." + "#{" + y + ",}" + "\\." + "#{" + z + ",}" + "$";
        var a = str.matches(patternBuilder.toString());
        if(a) {
            System.out.println(str);
        }
        return a;
    }




    private List<Long> findIndexesOfQuestnMark() {
        List<Long> indexesOfQuestnMark = new ArrayList<>();
        long index = infoStr.indexOf("?");
        while (index >= 0L) {
            indexesOfQuestnMark.add(index);
            index = (long) infoStr.indexOf("?", (int) (index + 1));
        }
        return indexesOfQuestnMark;
    }







    public static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }




    private void check(String combination) {
        var chars = combination.split("");
        var newStr = "";
        for (int i = 0; i < chars.length; i++) {
            newStr = changeCharInPosition(indexesOfQuestnMark.get(i).intValue(), combination.charAt(i), infoStr);
        }
        if (matchesPattern(newStr, countSet)) {
            arrangementCount++;
                System.out.println(arrangementCount);
        }
    }


    public long getArrangementCount() {
        System.out.println(arrangementCount);
        return arrangementCount;
    }
}
