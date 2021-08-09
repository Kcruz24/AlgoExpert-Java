package StaircaseTraversal;

public class StaircaseTraversalApp
{
    public static void main(String[] args) {
        System.out.println("Different ways: " + staircaseTraversal(4, 2));
    }

    // O(K^N) time | O(N) space
    public static int staircaseTraversal(int height, int maxSteps) {
        return staircaseTraversalHelper(height, maxSteps);
    }

    public static int staircaseTraversalHelper(int height, int maxSteps) {
        if (height <= 1)
            return 1;

        int ways = 0;

        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            ways += staircaseTraversalHelper(height - step, maxSteps);
        }

        return ways;
    }
}
