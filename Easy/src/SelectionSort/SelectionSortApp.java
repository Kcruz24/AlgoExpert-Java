package SelectionSort;

public class SelectionSortApp
{
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int lastIdx = array.length - 1; lastIdx > 0; lastIdx--) {
            int largest = 0;
            int idx;

            for (idx = 1; idx <= lastIdx; idx++)
                if (array[idx] > array[largest])
                    largest = idx;

            swap(array, lastIdx, largest);
        }
        return array;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
