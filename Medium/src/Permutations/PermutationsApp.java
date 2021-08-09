package Permutations;

import java.util.*;

public class PermutationsApp
{
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<Integer> objects = new ArrayList<>(Arrays.asList(1, 2, 3));

        //Collections.swap(objects, 1, 2);

        System.out.println(getPermutations(objects));
    }

    // O(N*N!) time | O(N*N!) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationsHelper(0, array, permutations);
        return permutations;
    }

    public static void getPermutationsHelper(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                // Get all posible permutations
                Collections.swap(array, i, j);
                getPermutationsHelper(i + 1, array, permutations);
                // reset original array order
                Collections.swap(array, i, j);
            }
        }
    }

    public static List<List<Integer>> combinations(List<Integer> set) {
        List<List<Integer>> combinations = new ArrayList<>();

        int idx = 0;
        int i = 0;
        int r = (set.size() - 2) * (set.size() - 1);

        while (i <= r) {
            while (idx + 1 < set.size()) {
                ArrayList<Integer> subset = new ArrayList<>(set);
                if (!combinations.contains(subset))
                    combinations.add(subset);

                Collections.swap(set, idx, idx + 1);
                idx++;
            }

            idx = 0;
            i++;
        }

        return combinations;
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
