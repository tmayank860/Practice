package Searching;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int index = ternarySearch(array, 0, array.length - 1, 6);
        System.out.println(index);
    }

    //------Required Condition: Array must be sorted-------
    // Time Complexity: O(log n + k) Here k > c of binary search
    private static int ternarySearch(int[] array, int startIndex, int endIndex, int elementToBeSearch) {
        if (startIndex <= endIndex) {
            int mid1 = startIndex + (endIndex - startIndex) / 3;
            int mid2 = endIndex - (endIndex - startIndex) / 3;
            if (array[mid1] == elementToBeSearch)
                return mid1;
            if (array[mid2] == elementToBeSearch)
                return mid2;
            if (array[mid1] > elementToBeSearch)
                return ternarySearch(array, startIndex, mid1 - 1, elementToBeSearch);
            /*if (array[mid1] < elementToBeSearch){
                if (array[mid2] < elementToBeSearch)
                    return ternarySearch(array,mid2+1,endIndex,elementToBeSearch);
                if (array[mid2]> elementToBeSearch)
                    return ternarySearch(array,mid1+1,mid2 -1,elementToBeSearch);
            }*/
            if (array[mid2] < elementToBeSearch)
                return ternarySearch(array, mid2 + 1, endIndex, elementToBeSearch);
            else
                return ternarySearch(array, mid1 + 1, mid2 - 1, elementToBeSearch);
        }
        return -1;
    }
}
