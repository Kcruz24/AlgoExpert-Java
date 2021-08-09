package FindClosestValueInBST;

public class FindClosestValueInBSTApp
{
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left.value = 5;
        bst.right.value = 15;


    }

    // Avg: O(log(N)) time | O(log(N)) space
    // Worst: O(N) time | O(N) space
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return traverseBST(tree, target, tree.value);
    }

    public static int traverseBST(BST tree, int target, int closest) {
        if (Math.abs(tree.value - target) < Math.abs(target - closest)) {
            closest = tree.value;
        }

        if (target < tree.value && tree.left != null) {
            return traverseBST(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return traverseBST(tree.right, target, closest);
        } else {
            return closest;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
