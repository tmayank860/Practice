package Searching.Questions;

public class PeakElement {
    // Question: Find the peak element in random array
    // A peak element is one which is greater than its neighbours

    public static void main(String[] args) {
        int[] array = /*{1,3,4,4,2,1,5};*/ {2, 7, 8, 9, 10};
        int element = findPeakElement(array, 0, array.length - 1);
        System.out.println(element);
    }


    //--------Brute Force Iterative approach----------
    // Time Complexity: O(n)
    // Input: {1,2}
    // Output: 2
    private static int peakElement(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        for (int i = 1; i < array.length - 2; i++) {
            if ((array[i - 1] < array[i])
                    && (array[i + 1] < array[i])) {
                return array[i];
            }
        }
        return array[array.length - 1];
    }

    //----------Recursive Approach using Binary Search---------------
    // Time Complexity: O(log n)
    // Input: {1,4}
    // Output: 4
    private static int findPeakElement(int[] array, int start, int end) {
        if (array.length == 1)
            return array[0];
        int mid = start + (end - start) / 2;
        if ((mid > 0 && array[mid - 1] <= array[mid]) &&
                (mid < array.length - 2 && array[mid + 1] <= array[mid]))
            return array[mid];
        if (mid > 0 && array[mid - 1] >= array[mid])
            return findPeakElement(array, start, mid - 1);
        else if (mid < array.length - 2 && array[mid + 1] >= array[mid])
            return findPeakElement(array, mid + 1, end);
        else
            return Math.max(array[mid], array[mid + 1]);
    }
}
