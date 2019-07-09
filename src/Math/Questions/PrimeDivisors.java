package Math.Questions;

import java.util.HashSet;
import java.util.Set;

public class PrimeDivisors {
    // Question: Find all distinct prime divisors of N

    public static void main(String[] args) {
        Set<Integer> primeDivisors = primeDivisors(2 * 97);
        System.out.println(primeDivisors);
    }

    // ---------Brute force approach-----------
    // Time Complexity: O(n√n)
    private static Set<Integer> findPrimeDivisorsOf(int number) {
        Set<Integer> primeDivisors = new HashSet<>();
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                if (isPrime(i))
                    primeDivisors.add(i);
            }
        }
        return primeDivisors;
    }

    //----------------Optimized approach------------
    // Time Complexity: O(√n * √n) => O(n)
    private static Set<Integer> primeDivisorsOfN(int number) {
        Set<Integer> primeDivisors = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (isPrime(i))
                    primeDivisors.add(i);
                if (isPrime(number / i))
                    primeDivisors.add(number / i);
            }
        }
        return primeDivisors;
    }

    // ----------Approach 3----------
    // Find a divisor and remove all factors of that divisor from number
    // Time Complexity: O(√n log n)
    private static Set<Integer> calculatePrimeDivisors(int number) {
        Set<Integer> primeDivisors = new HashSet<>();
        int num = number;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (num % i == 0) {
                primeDivisors.add(i);
                while (num % i == 0)
                    num /= i;
            }
        }
        return primeDivisors;
    }

    // Above two approach fails for instances where number is prime and co-prime
    // so we have to check that base case
    // ----------Efficient Approach-------
    // Time Complexity: O(√n + √n log n)
    private static Set<Integer> primeDivisors(int number) {
        Set<Integer> primeDivisors = new HashSet<>();
        if (isPrime(number))
            primeDivisors.add(number);
        else {
            int num = number;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (num % i == 0) {
                    primeDivisors.add(i);
                    while (num % i == 0)
                        num /= i;
                }
            }
            if (isPrime(num))
                primeDivisors.add(num);
        }
        return primeDivisors;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}