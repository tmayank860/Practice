package Searching;

public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {2, 9, 15, 1, 0, 26, 3};
        int index = linearSearch(array, 3);
        System.out.println(index);

    }

    // Time Complexity: O(n)
    private static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
