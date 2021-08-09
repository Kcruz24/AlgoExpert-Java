package MinimumWaitingTime;

import java.util.Arrays;

public class MinimumWaitingTimeApp
{
    public static void main(String[] args) {
        int[] array = {2, 1, 1, 1};

        System.out.println(minimumWaitingTime(array));
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += queries[j];
            }
        }

        return sum;
    }
}
