package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieve {
    // Question: Find all prime no's less than n

    private static int[] primes;

    public static void main(String[] args) {
        int testCaseCount = 10;

        // Input maxNSize and evaluate sieve for the same
        sieveOfEratosthenes(30);

        for (int i = 0; i < testCaseCount; i++) {
            int n = (int) (1 + Math.random() * 29);
            List<Integer> primes = findPrimeLessThan(n);
            System.out.printf("%d : ", n);
            for (Integer number : primes) {
                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }

    private static List<Integer> findPrimeLessThan(int n) {
        List<Integer> primeNos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (primes[i] == 1) {
                primeNos.add(i);
            }
        }
        return primeNos;
    }

    // Time Complexity: O(n log (log n))
    private static void sieveOfEratosthenes(int maxNSize) {
        primes = new int[maxNSize];
        // Mark all numbers as prime
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i <= Math.sqrt(maxNSize); i++) {
            if (primes[i] == 1) {
                // Mark all multiples of i as non prime
                for (int j = (int) Math.pow(i, 2); j < maxNSize; j += i) {
                    primes[j] = 0;
                }
            }
        }
    }
}