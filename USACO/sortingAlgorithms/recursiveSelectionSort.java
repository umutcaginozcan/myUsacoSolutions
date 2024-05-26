package sortingAlgorithms;

public class recursiveSelectionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 5, 3, 1};
        selectionSortMethod(array, 0);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void selectionSortMethod(int[] array, int start) {
        // Base Case
        if (start >= array.length - 1) {
            return;
        } 
        // Find the minimum element's index in the array from start to end
        int minIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        // Swap the minimum element with the element at the start index
        int temp = array[start];
        array[start] = array[minIndex];
        array[minIndex] = temp;

        // Recursive call to sort the remaining array
        selectionSortMethod(array, start + 1);
    }
}
