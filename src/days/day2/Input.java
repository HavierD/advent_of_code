package days.day2;

public class Input {
    public static final String testInput =
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
    public static final String input =
            "Game 1: 10 green, 9 blue, 1 red; 1 red, 7 green; 11 green, 6 blue; 8 blue, 12 green\n" +
                    "Game 2: 11 red, 7 green, 3 blue; 1 blue, 8 green, 5 red; 2 red, 12 green, 1 blue; 10 green, 5 blue, 7 red\n" +
                    "Game 3: 2 red, 7 green, 1 blue; 1 blue, 8 red; 7 green, 19 red, 5 blue; 1 blue, 10 green, 18 red; 10 red, 6 blue, 4 green\n" +
                    "Game 4: 2 blue, 5 green, 2 red; 7 red, 3 green; 3 blue, 2 red; 16 green, 2 blue\n" +
                    "Game 5: 1 blue, 9 red; 5 blue, 9 green, 6 red; 8 red, 10 blue, 3 green; 3 red, 13 green, 4 blue; 5 green, 9 red, 6 blue; 4 green, 8 red, 7 blue\n" +
                    "Game 6: 1 red, 2 green; 2 red, 1 blue; 5 red, 10 green, 2 blue; 1 blue, 2 green, 3 red; 1 red, 6 green\n" +
                    "Game 7: 9 blue, 14 green, 5 red; 10 green, 8 blue, 2 red; 20 green, 1 red; 4 blue, 17 green, 4 red\n" +
                    "Game 8: 16 blue, 16 green, 8 red; 16 blue, 6 red, 10 green; 13 blue, 8 green, 16 red; 10 red, 13 green, 13 blue\n" +
                    "Game 9: 8 blue, 10 green, 4 red; 18 green, 14 blue, 12 red; 4 green, 10 blue, 17 red; 16 red, 6 blue, 5 green; 11 red, 9 blue; 16 green, 13 red, 7 blue\n" +
                    "Game 10: 5 green, 2 red, 13 blue; 3 red, 2 green, 17 blue; 3 green, 12 blue, 15 red; 7 blue, 14 red; 3 red, 4 green, 17 blue\n" +
                    "Game 11: 8 green, 10 blue, 15 red; 11 blue, 4 green, 3 red; 10 blue, 4 green, 5 red; 7 blue, 1 green, 4 red; 2 red, 9 blue; 18 red, 8 green, 2 blue\n" +
                    "Game 12: 16 red, 10 green; 12 red, 8 blue, 3 green; 8 red, 10 green, 7 blue; 10 green, 12 red\n" +
                    "Game 13: 5 green, 2 red; 13 blue, 4 green, 4 red; 8 blue, 4 green\n" +
                    "Game 14: 9 green, 3 red, 1 blue; 1 blue, 3 red, 1 green; 6 green; 3 green, 5 red; 1 blue, 4 red\n" +
                    "Game 15: 13 red, 2 blue, 7 green; 6 green, 4 red, 7 blue; 8 blue, 11 red, 4 green; 1 green, 7 blue, 10 red; 3 blue, 9 green, 6 red; 6 green, 11 red, 1 blue\n" +
                    "Game 16: 1 red, 14 green; 4 green, 1 blue, 4 red; 3 red, 1 blue, 5 green; 5 red, 1 blue, 14 green; 1 blue, 1 red, 12 green; 6 red, 14 green, 1 blue\n" +
                    "Game 17: 14 green, 14 red; 19 green, 3 blue, 10 red; 4 green, 10 red, 1 blue\n" +
                    "Game 18: 9 green, 1 blue, 12 red; 1 green, 10 red; 1 blue, 3 red\n" +
                    "Game 19: 6 blue, 3 red, 3 green; 12 blue; 11 red, 14 blue, 3 green; 14 blue, 13 red, 1 green; 5 blue, 9 red\n" +
                    "Game 20: 10 blue, 11 green, 3 red; 2 red, 16 green; 6 blue, 16 green, 4 red; 14 green, 7 red, 1 blue; 5 red, 9 blue, 11 green\n" +
                    "Game 21: 1 red; 4 red; 2 red, 2 green, 1 blue\n" +
                    "Game 22: 11 green, 3 blue, 3 red; 12 blue, 6 green; 1 red, 5 blue, 1 green; 9 blue, 6 green; 10 green, 1 red, 8 blue\n" +
                    "Game 23: 13 blue, 3 green; 3 red, 5 green, 6 blue; 2 red, 11 green, 9 blue\n" +
                    "Game 24: 1 blue, 1 green; 1 blue; 1 red\n" +
                    "Game 25: 7 red, 1 green, 14 blue; 17 blue, 4 red, 6 green; 7 blue, 5 red; 2 red, 6 green, 20 blue\n" +
                    "Game 26: 10 green, 8 red, 11 blue; 13 green, 2 blue, 4 red; 1 blue, 6 green, 9 red\n" +
                    "Game 27: 9 green, 1 blue, 6 red; 7 red, 14 green; 13 green, 2 red; 2 red, 13 green; 2 green, 7 red\n" +
                    "Game 28: 10 red, 6 green; 7 green, 11 red, 1 blue; 8 red, 5 green; 10 green, 13 red; 17 red, 3 green\n" +
                    "Game 29: 4 blue, 3 red, 13 green; 9 green, 2 red, 1 blue; 11 green, 5 blue, 2 red; 1 blue, 7 green, 2 red; 4 blue, 1 red, 12 green\n" +
                    "Game 30: 6 blue, 1 green, 3 red; 1 green, 3 red, 1 blue; 6 green, 2 red, 2 blue\n" +
                    "Game 31: 11 red; 5 red, 2 green; 3 green, 6 red, 1 blue; 1 green, 18 red; 2 green, 14 red\n" +
                    "Game 32: 11 blue, 12 green, 11 red; 5 red, 14 blue, 5 green; 5 blue, 7 green, 18 red\n" +
                    "Game 33: 8 blue, 4 green, 11 red; 14 blue, 11 red, 3 green; 3 green, 1 blue; 17 red, 2 green, 9 blue; 7 green, 7 blue, 3 red; 2 green, 3 red, 7 blue\n" +
                    "Game 34: 1 blue, 17 green; 2 blue, 1 red, 10 green; 10 green, 1 red; 6 green, 1 red, 1 blue; 2 green, 2 blue, 1 red\n" +
                    "Game 35: 1 blue, 5 red, 5 green; 4 blue, 3 green, 8 red; 5 green, 14 blue; 5 green, 4 blue, 14 red\n" +
                    "Game 36: 13 green, 7 red, 2 blue; 2 red, 2 green; 1 red, 12 green; 7 green, 8 red\n" +
                    "Game 37: 11 red, 4 green, 1 blue; 12 red, 3 green, 5 blue; 1 blue, 12 red, 1 green; 9 red, 10 green; 7 red, 2 blue, 5 green; 7 green, 1 red, 4 blue\n" +
                    "Game 38: 14 red, 20 blue, 6 green; 14 red, 12 green, 13 blue; 10 green, 10 red, 9 blue; 9 green, 9 blue, 15 red\n" +
                    "Game 39: 4 blue; 8 green, 7 blue; 12 green, 2 blue, 5 red; 2 blue, 3 green, 3 red; 5 red, 1 green, 1 blue; 6 red, 1 blue\n" +
                    "Game 40: 7 green, 10 red, 3 blue; 2 blue, 1 red, 7 green; 2 red, 5 blue, 11 green; 4 blue, 12 red, 6 green; 13 green, 7 blue, 9 red; 14 blue, 7 green, 8 red\n" +
                    "Game 41: 14 red, 17 blue, 3 green; 18 blue, 4 green, 17 red; 2 green, 17 red, 8 blue; 7 green, 13 blue, 6 red\n" +
                    "Game 42: 1 blue, 16 green; 14 green; 17 blue, 4 green, 7 red; 6 red, 7 blue, 8 green\n" +
                    "Game 43: 8 red, 15 blue; 8 red, 1 green, 11 blue; 17 blue, 3 red\n" +
                    "Game 44: 10 red, 2 green, 11 blue; 8 green, 4 blue, 6 red; 6 green, 2 blue, 10 red; 1 blue, 12 red, 7 green\n" +
                    "Game 45: 1 blue, 4 red, 4 green; 2 red, 5 green; 3 green, 6 blue, 1 red; 12 blue, 1 red, 2 green\n" +
                    "Game 46: 2 blue; 1 red, 4 blue; 2 blue, 15 red; 3 blue, 4 green, 5 red; 4 green, 13 red; 1 blue, 3 green, 9 red\n" +
                    "Game 47: 13 blue, 2 green, 2 red; 2 green, 12 blue, 3 red; 2 green, 1 blue\n" +
                    "Game 48: 1 blue, 4 green, 11 red; 2 blue, 5 red, 8 green; 6 red\n" +
                    "Game 49: 1 red, 10 green; 3 green, 8 blue, 5 red; 7 red, 5 green, 7 blue\n" +
                    "Game 50: 12 blue, 5 green, 1 red; 7 blue, 2 red; 12 blue, 3 green; 16 blue; 1 blue, 3 green; 2 red, 14 blue, 11 green\n" +
                    "Game 51: 6 blue, 15 red, 1 green; 15 red, 2 blue, 1 green; 12 red, 2 green\n" +
                    "Game 52: 5 green, 11 blue, 5 red; 18 green, 4 red, 10 blue; 14 green, 8 blue, 8 red; 2 red, 9 green, 11 blue; 9 blue, 5 red, 10 green\n" +
                    "Game 53: 1 red, 1 green; 2 green, 1 red, 2 blue; 2 green, 1 blue\n" +
                    "Game 54: 4 blue, 3 red, 7 green; 4 blue, 13 green; 1 red, 2 green, 7 blue; 5 blue, 5 red, 17 green\n" +
                    "Game 55: 8 red, 11 green, 11 blue; 1 green, 15 blue, 6 red; 7 red, 8 blue, 11 green; 2 green, 1 red, 11 blue; 11 blue, 3 red; 3 red, 7 blue, 10 green\n" +
                    "Game 56: 13 blue, 3 green; 1 red, 1 green, 7 blue; 17 blue, 2 red; 3 blue, 4 green, 4 red\n" +
                    "Game 57: 9 green, 11 blue, 12 red; 13 red, 6 green, 1 blue; 4 blue, 1 green, 14 red; 11 red, 6 blue, 3 green\n" +
                    "Game 58: 7 green, 2 blue, 6 red; 1 red, 4 green; 1 blue, 8 green, 10 red\n" +
                    "Game 59: 3 green, 11 red, 3 blue; 1 blue, 5 red, 8 green; 10 green, 9 red; 5 green, 5 red, 1 blue; 4 green, 8 blue; 13 green\n" +
                    "Game 60: 2 blue, 11 green, 7 red; 5 red, 9 green, 2 blue; 3 blue, 2 red, 8 green; 6 red, 2 blue, 9 green; 5 red, 4 green, 2 blue; 6 red, 5 blue, 11 green\n" +
                    "Game 61: 7 blue, 5 green, 8 red; 12 blue, 1 red, 11 green; 15 blue, 14 red, 15 green; 14 red, 7 blue, 6 green; 9 blue; 3 green, 10 blue, 11 red\n" +
                    "Game 62: 8 red, 1 blue, 1 green; 2 red, 1 blue, 8 green; 11 blue, 15 red, 4 green; 1 red, 5 green, 2 blue; 15 green, 11 blue, 12 red\n" +
                    "Game 63: 6 red, 3 green, 7 blue; 8 red, 2 green; 4 green, 3 red, 4 blue; 6 blue, 3 red, 10 green; 4 blue, 6 red, 9 green; 8 blue, 10 green, 5 red\n" +
                    "Game 64: 1 blue, 9 red, 1 green; 17 red, 3 blue; 8 red, 2 green; 12 red, 8 blue\n" +
                    "Game 65: 15 blue, 2 red; 1 green, 14 blue; 10 green, 1 red, 10 blue; 10 green, 1 red, 12 blue; 13 blue, 1 green\n" +
                    "Game 66: 18 green, 3 red, 7 blue; 19 blue, 2 red; 5 red, 8 blue, 11 green; 1 red, 15 blue, 12 green; 13 blue, 6 green; 12 blue, 6 green\n" +
                    "Game 67: 1 blue, 2 green, 6 red; 7 red, 5 blue; 9 red, 13 blue, 5 green; 4 green, 4 blue, 5 red; 11 blue, 7 red; 3 blue, 9 red\n" +
                    "Game 68: 2 blue, 8 green, 16 red; 11 green, 13 blue; 6 red, 7 green, 1 blue; 4 green, 7 red, 8 blue\n" +
                    "Game 69: 7 green, 3 blue, 5 red; 11 green, 4 blue; 1 red, 15 green, 10 blue; 8 green, 12 blue, 4 red\n" +
                    "Game 70: 8 blue, 8 green; 4 blue, 1 red, 6 green; 1 green, 1 blue; 7 green, 4 blue\n" +
                    "Game 71: 7 red, 13 blue, 4 green; 2 blue, 11 red, 9 green; 14 blue, 6 green, 2 red; 10 red, 6 blue, 10 green\n" +
                    "Game 72: 1 blue, 9 green, 1 red; 4 blue, 6 green, 1 red; 1 red, 3 green, 3 blue; 10 green, 3 blue, 2 red; 3 blue, 1 red, 1 green; 3 green, 1 red, 3 blue\n" +
                    "Game 73: 4 green, 15 red, 6 blue; 1 green, 12 red; 2 green, 16 red; 1 green, 12 red, 2 blue; 6 red, 4 green, 2 blue; 19 red, 3 blue, 2 green\n" +
                    "Game 74: 14 green, 2 blue, 3 red; 13 green, 4 red; 3 green, 4 blue; 3 blue, 3 red; 2 red, 12 green; 3 blue, 3 green\n" +
                    "Game 75: 13 red, 10 blue, 1 green; 14 blue, 9 red, 2 green; 8 blue; 1 green, 13 red, 11 blue\n" +
                    "Game 76: 2 red, 8 blue, 12 green; 11 green, 2 red; 2 red, 2 blue, 10 green; 5 blue, 2 green; 3 red, 11 green, 8 blue\n" +
                    "Game 77: 4 blue, 8 red, 14 green; 15 green, 12 red, 5 blue; 8 red, 5 green, 1 blue\n" +
                    "Game 78: 8 red, 19 blue, 4 green; 18 blue, 2 red; 12 blue, 4 green, 8 red; 17 blue, 2 green, 9 red; 9 red, 10 blue, 1 green; 6 green, 9 blue, 1 red\n" +
                    "Game 79: 1 blue, 11 red, 2 green; 2 red, 2 green, 6 blue; 11 red, 2 blue, 2 green; 11 red, 2 green, 4 blue\n" +
                    "Game 80: 1 red, 9 blue; 1 red, 5 blue, 8 green; 5 green, 1 red, 4 blue; 2 green, 9 blue, 1 red; 7 blue, 1 green, 1 red\n" +
                    "Game 81: 1 green, 1 blue, 7 red; 3 blue, 7 green, 6 red; 5 green; 3 blue; 3 red, 4 blue, 1 green; 5 red, 9 green\n" +
                    "Game 82: 12 blue, 4 red, 4 green; 7 red, 4 blue; 3 green, 10 red, 3 blue; 6 blue, 13 red; 4 blue, 5 red, 1 green\n" +
                    "Game 83: 1 red, 1 green, 18 blue; 20 blue, 16 red, 1 green; 17 blue, 12 red; 1 green, 9 blue, 7 red\n" +
                    "Game 84: 6 blue, 7 green, 6 red; 6 red, 10 green, 1 blue; 5 red, 8 green; 13 green, 2 red, 7 blue\n" +
                    "Game 85: 1 blue, 7 red, 11 green; 1 red; 8 red, 10 green, 4 blue; 4 red, 11 green, 1 blue; 1 blue, 6 green\n" +
                    "Game 86: 9 green, 2 blue; 3 red, 1 green, 2 blue; 1 green, 5 blue, 9 red; 1 blue, 2 green; 9 red, 1 green, 4 blue\n" +
                    "Game 87: 15 red, 1 green, 16 blue; 1 green, 6 red, 17 blue; 7 red, 1 green, 3 blue; 8 red, 3 blue, 1 green; 15 red, 1 green\n" +
                    "Game 88: 7 green, 3 red, 10 blue; 8 blue, 8 red, 3 green; 18 green, 1 blue, 7 red; 8 red, 7 green, 10 blue\n" +
                    "Game 89: 5 red, 16 blue; 7 blue; 5 blue, 4 red; 3 blue, 4 green, 6 red; 1 red, 2 green, 16 blue\n" +
                    "Game 90: 19 blue, 5 green, 4 red; 2 green, 20 blue, 1 red; 18 blue\n" +
                    "Game 91: 10 red, 11 blue, 1 green; 18 red, 12 blue; 11 blue, 10 red\n" +
                    "Game 92: 3 green, 1 blue; 8 red, 5 green; 10 red, 3 green\n" +
                    "Game 93: 5 green, 1 blue, 5 red; 1 blue, 2 red, 7 green; 2 green, 6 red, 1 blue; 7 green, 1 blue, 2 red; 6 red, 1 green\n" +
                    "Game 94: 3 red, 6 blue, 2 green; 5 blue, 9 red; 11 blue, 5 red, 2 green; 2 green, 3 red, 14 blue; 5 red, 13 blue; 6 blue, 2 green, 8 red\n" +
                    "Game 95: 4 red, 3 green, 17 blue; 1 red, 5 green, 4 blue; 15 blue, 11 green; 5 green, 1 red, 4 blue; 11 blue, 2 green, 17 red\n" +
                    "Game 96: 3 red, 20 blue, 18 green; 1 red, 1 blue, 20 green; 18 blue, 4 green, 8 red\n" +
                    "Game 97: 11 green; 7 red, 8 green, 2 blue; 4 green, 17 red; 4 green, 7 red; 14 green, 18 red, 2 blue\n" +
                    "Game 98: 2 blue, 7 green, 1 red; 9 green, 10 red, 5 blue; 13 blue, 10 red, 8 green; 8 green, 11 red, 12 blue; 5 blue, 4 green, 2 red\n" +
                    "Game 99: 2 blue, 13 green; 1 blue; 1 red, 2 blue, 2 green; 1 red, 1 blue\n" +
                    "Game 100: 1 red, 14 green; 17 green, 12 red; 3 green, 7 red, 3 blue; 4 green, 13 red, 3 blue; 5 green, 11 red, 5 blue";
}
