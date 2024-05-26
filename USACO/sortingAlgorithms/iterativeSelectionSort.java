package sortingAlgorithms;

public class iterativeSelectionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 5, 3, 1};
        selectionSortMethod(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public static void selectionSortMethod (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = array[i + 1];
            int smallestIndex = i + 1;
            for (int j = i + 1; j < array.length; j++) {
                // Find the smallest element
                if (array[j] <= smallest) {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            if (smallest < array[i]) {
                // Swap the elements.
                int temp = array[i];
                array[i] = smallest;
                array[smallestIndex] = temp;
            }
        }
    }
}
