package Math;

public class Prime {
    public static void main(String[] args) {
        boolean prime = checkForPrime(99999989);
        System.out.println(prime);
    }

    //--------- Brute Force Approach --------
    // Time Complexity: O(n)
    private static boolean isPrime(int number) {
        if (number == 1)
            return false;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    //--------- Modified Brute Force Approach --------
    // Time Complexity: O(n)
    private static boolean isPrimeNo(int number) {
        if (number == 1)
            return false;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    //--------- Efficient Approach --------
    // Time Complexity: O(√n)
    private static boolean checkForPrime(int number) {
        if (number == 1)
            return false;
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
