package Searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 10, 20, 25};
        int index = binarySearch(array, 0, array.length - 1, 1);
        System.out.println(index);
    }

    // --------Required Condition: Array must be sorted-------
    // Sample Testcase 1: {2, 3, 4, 5, 10, 20, 25}
    // Input: 5  startIndex: 0 endIndex: 6
    // Output: 3
    // Time Complexity: O(log n + c)
    private static int binarySearch(int[] array, int startIndex,
                                    int endIndex, int elementToBeSearch) {
        if (startIndex <= endIndex) {
            // NOTE: Using (start + end) / 2 can break the code
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (array[mid] == elementToBeSearch)
                return mid;
            if (array[mid] < elementToBeSearch)
                return binarySearch(array, mid + 1, endIndex, elementToBeSearch);
            if (array[mid] > elementToBeSearch)
                return binarySearch(array, startIndex, mid - 1, elementToBeSearch);
        }
        return -1;
    }

    // -----------Iterative Approach ----------
    // Sample Testcase 1: {2, 3, 4, 5, 10, 20, 25}
    // Input: 7  startIndex: 0 endIndex: 6
    // Output: -1
    // Time Complexity: O(log n + c)
    private static int binarySearch(int[] array, int element) {
        int startIndex = 0, endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (array[mid] == element)
                return mid;
            if (array[mid] < element)
                startIndex = mid + 1;
            else
                endIndex = mid - 1;
        }
        return -1;
    }
}