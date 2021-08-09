package InsertionSort;

public class InsertionSortApp
{
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            int newElem = array[i];
            int j;

            for (j = i; j > 0 && array[j - 1] > newElem; j--)
                array[j] = array[j - 1];

            array[j] = newElem;
        }

        return array;
    }
}
