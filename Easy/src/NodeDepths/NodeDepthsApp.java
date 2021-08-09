package NodeDepths;

import java.util.ArrayList;
import java.util.List;

public class NodeDepthsApp
{
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        List<Integer> array = new ArrayList<>();
        int sum = 0, suma = 0;

        if (root.left != null) {
            sum += 1;
            nodeDepths(root.left);
        }

        for (int i = 1; i <= sum; i++) {
            array.add(i);
        }

        if (root.right != null) {
            nodeDepths(root.right);
        }

        sum = 0;

        for (Integer n : array) {
            sum += n;
        }

        return helperFunction(root, suma);
    }

    public static int helperFunction(BinaryTree root, int sum) {

        if (root.left != null) {
            helperFunction(root.left, sum + 1);
        }

        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
