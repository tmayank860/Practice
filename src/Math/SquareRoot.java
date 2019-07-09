package Math;

public class SquareRoot {
    public static void main(String[] args) {
        int number = 2147395599;
        int squareRoot = findSquareRootOf(number, 0, number / 2);
        System.out.println(squareRoot);
    }

    //--------- Using binary search ----------
    // Find a no which when multiplied by itself return the given number
    // Time Complexity: O(log n)
    // Input: 2147395599
    // Output: 46339
    private static int findSquareRootOf(int n, int startIndex, int endIndex) {
        if (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (mid > n / mid)
                return findSquareRootOf(n, startIndex, mid - 1);
            if (mid + 1 > n / (mid + 1))
                return mid;
            return findSquareRootOf(n, mid + 1, endIndex);
        }
        return -1;
    }
}
