package sortingAlgorithms;

public class interativeInsertionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 5, 3, 1};
        insertionSortMethod(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertionSortMethod(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int k;
            for (k = i - 1; k >= 0 && current < array[k] ; k--) {
                array[k + 1] = array[k];
            }
            array[k + 1] = current; // En sonda bir eksildiği için ekleme lazım
        }
    }
}
