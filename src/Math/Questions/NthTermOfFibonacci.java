package Math.Questions;

public class NthTermOfFibonacci {
    private static int[] fSeries;

    public static void main(String[] args) {
        int testCaseCount = 5;
        int maxNSize = 30;
        fSeries = initializeFibonacci(maxNSize);
        for (int i = 0; i < testCaseCount; i++) {
            int n = (int) (1 + Math.random() * 30);
            int nthTerm = evaluateNthTermOfFibonacci(n);
            System.out.printf("%d: %d\n", n, nthTerm);
        }
    }

    //-----------Iterative approach----------
    // Time Complexity: O(n)
    private static int findNthTermOfFibonacci(int n) {
        if (n <= 2)
            return n - 1;
        int a = 0;
        int b = 1;
        int c = -1;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //-------------Recursive Approach---------
    // Time Complexity: O(2ⁿ)
    private static int nthTermOfFibonacci(int number) {
        if (number <= 2)
            return number - 1;
        return nthTermOfFibonacci(number - 1) + findNthTermOfFibonacci(number - 2);
    }

    //-----------Best Approach using dynamic programming----------
    // Calculate full fibonacci series one time then access the
    // answer in constant time complexity
    private static int evaluateNthTermOfFibonacci(int n) {
        if (n <= 2)
            return n - 1;
        return fSeries[n - 1] + fSeries[n - 2];
    }

    private static int[] initializeFibonacci(int maxSize) {
        fSeries = new int[maxSize];
        fSeries[0] = 0;
        fSeries[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fSeries[i] = fSeries[i - 1] + fSeries[i - 2];
        }
        return fSeries;
    }
}