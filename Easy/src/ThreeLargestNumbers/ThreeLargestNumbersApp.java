package ThreeLargestNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeLargestNumbersApp
{
    public static void main(String[] args) {
        int[] array = {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7};

        System.out.println(Arrays.toString(findThreeLargestNumbers(array)));
    }

    // O(n) time || O(n) space
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] numbers = new int[3];
        List<Integer> arrayList = new ArrayList<>();

        for (int integer : array) {
            arrayList.add(integer);
        }

        int largestNum = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j) > largestNum) {
                    largestNum = arrayList.get(j);
                    index = j;
                }
            }

            numbers[i] = largestNum;
            arrayList.remove(index);
            largestNum = Integer.MIN_VALUE;
        }

        Arrays.sort(numbers);
        return numbers;
    }
}
