package NonConstructibleChange;

import java.util.Arrays;

public class NonConstructibleChangeApp
{
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins) {

        if (coins.length == 1 && coins[0] != 1 || coins.length == 0)
            return 1;
        else if (coins.length == 1)
            return 2;

        Arrays.sort(coins);
        int change = coins[0];

        for (int i = 0; i < coins.length - 1; i++) {
            if (coins[i + 1] > change + 1) {
                return change + 1;
            } else if (coins[i + 1] <= change + 1) {
                change += coins[i + 1];
            }
        }

        return change + 1;
    }
}
