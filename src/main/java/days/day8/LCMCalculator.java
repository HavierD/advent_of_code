package days.day8;

public class LCMCalculator {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static int lcmOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // Replace these values with the six numbers for which you want to find the LCM
        int[] numbers = {2, 3, 4, 5, 6, 7};

        int result = lcmOfArray(numbers);

        System.out.print("LCM of the numbers is: " + result);
    }
}
