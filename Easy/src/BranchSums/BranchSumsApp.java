package BranchSums;

import java.util.ArrayList;
import java.util.List;

public class BranchSumsApp
{
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> branches = new ArrayList<>();
        calculateBranchSums(root, 0, branches);
        return branches;
    }

    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null)
            return;

        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }
}