package days.day1;

import java.util.List;

public class Converter {
    private final static List<String> words3Chars = List.of("one", "two", "six");
    private final static List<String> words4Chars = List.of("four", "five", "nine");
    private final static List<String> words5Chars = List.of("three", "seven", "eight");

    public String convertFirstStringNumFromTheEnd(String line) {
        if (line.length() < 3) {
            return line;
        }

        var index = line.length();
        if (!line.substring(index - 3, index).replaceAll("[^\\d]", "").isEmpty()) {
            return line;
        }
        while (true) {
            if (index < 3) {
                return line;
            }
            String word = tryToFindWordBackward(line, index);
            if (word != null) {
                return replaceLast(line, word, String.valueOf(parseInt(word)));
            }

            index--;
        }
    }

    public String convertFirstStringNumFromTheBeginning(String line) {

        if (line.length() < 3) {
            return line;
        }
        var index = 0;

        if (!line.substring(index, index + 3).replaceAll("[^\\d]", "").isEmpty()) {
            return line;
        }

        while (true) {
            String word = tryToFindWordForward(line, index);
            if (word != null) {
                return line.replaceFirst(word, String.valueOf(parseInt(word)));
            }
            if (line.length() - index == 3) {
                return line;
            }
            index++;
        }
    }

    public int parseInt (String word) {
        if (word.equals("one")) {
            return 1;
        }
        if (word.equals("two")) {
            return 2;
        }
        if (word.equals("three")) {
            return 3;
        }
        if (word.equals("four")) {
            return 4;
        }
        if (word.equals("five")) {
            return 5;
        }
        if (word.equals("six")) {
            return 6;
        }
        if (word.equals("seven")) {
            return 7;
        }
        if (word.equals("eight")) {
            return 8;
        }
        if (word.equals("nine")) {
            return 9;
        }

        throw new IllegalArgumentException("word is not a number");
    }

    private String tryToFindWordBackward(String originalString, int index) {
        var possibleWord = check3CharsBackward(originalString, index);
        if (possibleWord != null) {
            return possibleWord;
        }
        if (index > 3) {
            possibleWord = check4CharsBackward(originalString, index);
            if (possibleWord != null) {
                return possibleWord;
            }
        }

        if (index > 4) {
            possibleWord = check5CharsBackward(originalString, index);
            if (possibleWord != null) {
                return possibleWord;
            }
        }
        return null;
    }

    private String tryToFindWordForward(String originalString, int index) {
        var possibleWord = check3CharsForward(originalString, index);
        if (possibleWord != null) {
            return possibleWord;
        }
        if (originalString.length() - index > 3) {
            possibleWord = check4CharsForward(originalString, index);
            if (possibleWord != null) {
                return possibleWord;
            }
        }

        if (originalString.length() - index > 4) {
            possibleWord = check5CharsForward(originalString, index);
            if (possibleWord != null) {
                return possibleWord;
            }
        }
        return null;
    }

    private String check3CharsBackward(String originalString, int index) {
        var subStr = originalString.substring(index - 3, index);
        if (words3Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }

    private String check4CharsBackward(String originalString, int index) {
        var subStr = originalString.substring(index - 4, index);
        if (words4Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }

    private String check5CharsBackward(String originalString, int index) {
        var subStr = originalString.substring(index - 5, index);
        if (words5Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }

    private String check3CharsForward(String originalString, int index) {
        var subStr = originalString.substring(index, index + 3);
        if (words3Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }

    private String check4CharsForward(String originalString, int index) {
        var subStr = originalString.substring(index, index + 4);
        if (words4Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }

    private String check5CharsForward(String originalString, int index) {
        var subStr = originalString.substring(index, index + 5);
        if (words5Chars.contains(subStr)) {
            return subStr;
        }
        return null;
    }



    private String replaceLast(String originalString, String toReplace, String replacement) {
        var index = originalString.lastIndexOf(toReplace);
        if (index == -1) {
            return originalString;
        }
        return originalString.substring(0, index) + replacement + originalString.substring(index + toReplace.length());
    }

    public static void main(String[] args) {
        var a = "123456789";
        System.out.println(a.substring(0, 0+3));
    }


}
