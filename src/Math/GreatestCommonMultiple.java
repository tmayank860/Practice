package Math;

public class GreatestCommonMultiple {
    public static void main(String[] args) {
        int gcd = greatestCommonMultiple(98, 56);
        System.out.println(gcd);
    }

    //--------Brute Force Approach--------
    // GCD is the greatest number that divides both a and b
    // Time Complexity: O(n)
    private static int greatestCommonMultiple(int a, int b) {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = 1; i < min; i++) {
            // Check if i divides both a and b
            if ((a % i == 0) && (b % i == 0))
                gcd = i;
        }
        return gcd;
    }

    // -----------Optimized above approach to reduce iteration-----
    // Time Complexity: O(n)
    private static int calculateGreatestCommonMultiple(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i > 1; i--) {
            // Check if i divides both a and b
            if ((a % i == 0) && (b % i == 0))
                return i;
        }
        return 1;
    }

    // ------Euclidean algorithm---------
    // Time Complexity: O(log n)
    private static int calculateGcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int remainder = max % min;
        if (remainder == 0)
            return min;
        return calculateGcd(min, remainder);
    }
}