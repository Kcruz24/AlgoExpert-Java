package SearchInSortedMatrix;

import java.util.Arrays;

public class SearchInSortedMatrixApp
{
    public static void main(String[] args) {
        int[] array = {40, 41, 42, 44, 45, 1003};
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };
        int target = 1003;

        System.out.println(Arrays.toString(searchInSortedMatrix(matrix, target)));
        System.out.println(matrix[searchInSortedMatrix(matrix, target)[0]][searchInSortedMatrix(matrix, target)[1]]);
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int rowIdx = -1;
        int colIdx = -1;

        for (int j = 0; j < matrix[0].length - 1; j++) {
            if (binarySearch(matrix, 0, matrix[j].length - 1, target, "col", j)) {
                rowIdx = j;
                break;
            }
        }

        for (int i = 0; i <= matrix.length; i++) {
            if (binarySearch(matrix, 0, matrix.length - 1, target, "row", i)) {
                colIdx = i;
                break;
            }
        }
        return new int[] {rowIdx, colIdx};
    }

    public static boolean binarySearch(int[][] array, int startIdx, int lastIdx, int target, String dir, int rowOrCol) {

        if (dir.equals("col")) {
            while (startIdx <= lastIdx) {
                int middle = (lastIdx + startIdx) / 2;

                if (array[rowOrCol][middle] == target) {
                    return true;
                } else if (array[rowOrCol][middle] > target) {
                    lastIdx = middle - 1;
                } else if (array[rowOrCol][middle] < target) {
                    startIdx = middle + 1;
                }
            }
        } else {
            while (startIdx <= lastIdx) {
                int middle = (lastIdx + startIdx) / 2;

                if (array[middle][rowOrCol] == target) {
                    return true;
                } else if (array[middle][rowOrCol] > target) {
                    lastIdx = middle - 1;
                } else if (array[middle][rowOrCol] < target) {
                    startIdx = middle + 1;
                }
            }
        }

        return false;
    }
}
