package sortingAlgorithms;

public class recursiveInsertionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 5, 3, 1};
        insertionSortMethod(array, 0);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertionSortMethod(int[] array, int start) {
        if (start >= array.length - 1) {
            return;
        }
        int current = array[start + 1];
        int k;
        for (k = start; k >= 0 && current < array[k] ; k--) {
            array[k + 1] = array[k];
        }
        array[k + 1] = current; // En sonda bir eksildiği için ekleme lazım.
        insertionSortMethod(array, start + 1);
    }
}
