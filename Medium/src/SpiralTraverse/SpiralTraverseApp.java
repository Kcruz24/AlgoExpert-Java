package SpiralTraverse;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverseApp
{
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };

        System.out.println(spiralTraverse2(array));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // first corner is [0][0] → [1][1]; plus one on both
        // second corner is [0][3] → [1][2]; plus one on rows, minus one on columns
        // third corner is [3][3] → [2][2]; minus one on both
        // fourth corner is [3][0] → [2][1]; minus one on rows, plus one on columns
        List<Integer> spiralOrder = new ArrayList<>();
        int p1 = 0, p1p = 0;
        int p2 = 0, p2p = array[0].length - 1;
        int p3 = array.length - 1, p3p = array[0].length - 1;
        int p4 = array.length - 1, p4p = 0;
        var counter = 0;

        while (counter < 2) {

            while (p1 < p2p) {
                spiralOrder.add(array[p1p][p1]);
                p1++;
            }
            p1 = 0;

            while (p2 < p3p) {
                spiralOrder.add(array[p2][p2p]);
                p2++;
            }
            p2 = 0;

            while (p3 > p4p) {
                spiralOrder.add(array[p3p][p3]);
                p3--;
            }
            p3 = array.length - 1;

            while (p4 > p1p) {
                spiralOrder.add(array[p4][p4p]);
                p4--;
            }
            p4 = array.length - 1;


            p1 += 1; p1p += 1;
            p2 += 1; p2p -= 1;
            p3 -= 1; p3p -= 1;
            p4 -= 1; p4p += 1;
            counter++;
        }

        return spiralOrder;
    }

    public static List<Integer> spiralTraverse2(int[][] array) {
        var spiralList = new ArrayList<Integer>();
        int startRow = 0;
        int startCol = 0;
        int endRow = array.length - 1;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top edge
            for (int col = startCol; col <= endCol; col++) {
                spiralList.add(array[startRow][col]);
            }

            // Right edge
            for (int row = startRow + 1; row <= endRow; row++) {
                spiralList.add(array[row][endCol]);
            }

            // Down edge
            for (int col = endCol - 1; col >= startCol; col--) {
                // Handles edge case when there's a single row in the middle
                if (startRow == endRow) break;
                spiralList.add(array[endRow][col]);
            }

            // Left edge
            for (int row = endRow - 1; row > startRow; row--) {
                // Handles edge case when there's a single column in the middle
                if (startCol == endCol) break;
                spiralList.add(array[row][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return spiralList;
    }
}
