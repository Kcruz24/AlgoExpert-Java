package ProductSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSumApp
{
    public static void main(String[] args) {
        // [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
        List<Object> test = new ArrayList<>(Arrays.asList(
                5, // Depth 1
                2, // Depth 1
                new ArrayList<>(Arrays.asList(7, -1)), // Depth 2
                3, // Depth 1
                new ArrayList<>(Arrays.asList(
                        6, // Depth 2
                        new ArrayList<>(Arrays.asList(-13, 8)), // Depth 3
                        4)))); // Depth 2

        System.out.println(productSum(test));
    }

    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    // O(N) time | O(D) space - where N is the elements of each array including the result elements of the nested arrays
    // and D is the depth of the nested arrays.
    private static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;

        for (Object object : array) {
            if (object instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> subList = (ArrayList<Object>) object;
                sum += productSumHelper(subList, multiplier + 1);
            } else {
                sum += (int) object;
            }
        }

        return sum * multiplier;
    }
}
