package Powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowersetApp
{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        System.out.println(powerset(list));
    }

    // O(N*2^N) time | O(N*2^N) space
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> powerset = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        powerset.add(subset);

        for (Integer integer : array) {
            int size = powerset.size();
            for (int j = 0; j < size; j++) {
                subset = new ArrayList<>(powerset.get(j));
                subset.add(integer);

                powerset.add(subset);
            }
        }

        return powerset;
    }
}
