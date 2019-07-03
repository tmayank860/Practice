package Math;

public class SquareRoot {
    public static void main(String[] args) {
        int number = 80;
        int root = findSquareRootOf(number, 0, number / 2, 1);
        System.out.println(root);
    }

    //--------- Using binary search ----------
    // Find a no which when multiplied by itself return the given number
    // Time Complexity: O(log n)
    private static int findSquareRootOf(int n, int startIndex, int endIndex, int root) {
        if (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            int midSquare = mid * mid;
            if (midSquare == n)
                return mid;
            if (midSquare > n)
                return findSquareRootOf(n, startIndex, mid - 1, root);
            return findSquareRootOf(n, mid + 1, endIndex, mid);
        }
        return root;
    }
}
