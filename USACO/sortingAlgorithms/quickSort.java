package sortingAlgorithms;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSortMethod(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSortMethod(int[] arr) {
        // Base Case Here:
        if (arr.length > 1) {
            // Merge Sort First Half
            int[] firstHalf = new int[arr.length / 2];
            System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
            mergeSortMethod(firstHalf);

            // Merge Sort Second Half
            int secondHalfLength = arr.length - arr.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
            mergeSortMethod(secondHalf);

            merge(firstHalf, secondHalf, arr);
        }
    }

    public static void merge (int[] list1, int[] list2, int[] temp) {
        
    }
}
