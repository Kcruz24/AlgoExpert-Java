package FirstDuplicateValue;

import java.util.*;

public class FirstDuplicateValueApp
{
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 3, 2, 4};

        System.out.println(firstDuplicateValue4(array));
    }

    // Brute Force first solution by me
    // O(N^2) time | O(N) space - where N is the number of values
    public static int firstDuplicateValue(int[] array) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (j < minIndex) {
                        minIndex = j;
                        integerMap.put(array[i], minIndex);
                    }
                    count++;
                }
            }
        }

        if (count > 0) {
            return Collections.min(integerMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        }

        return -1;
    }

    // Brute force second solution
    // O(N^2) time | O(1) space - where N is the number of values
    public static int firstDuplicateValue2(int[] array) {
        int minIndex = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (j < minIndex) {
                        minIndex = j;
                    }
                    count++;
                }
            }
        }

        if (count > 0) {
            return array[minIndex];
        }

        return -1;
    }

    // First optimal solution
    // O(N) time | O(N) space - where N is the number of values
    public static int firstDuplicateValue3(int[] array) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i : array) {
            if (hashSet.contains(i))
                return i;
            else
                hashSet.add(i);
        }

        return -1;
    }

    // Most optimal solution
    // O(N) time | O(1) space - where N is the number of values
    public static int firstDuplicateValue4(int[] array) {
        int index;

        for (int i = 0; i < array.length; i++) {
            index = Math.abs(array[i]) - 1;

            if (array[index] < 0)
                return Math.abs(array[i]);

            array[index] *= -1;
        }

        return -1;
    }
}
