class Solution {
    // Time Complexity: O(N) - We visit each node exactly once.
    // Space Complexity: O(H) - The height of the tree, which is the maximum depth of the recursive call stack.

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return helper(root, sum);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;

        // Check if the current node is a leaf (no left or right child)
        if (root.left == null && root.right == null) {
            // If it's a leaf, calculate the sum by multiplying the current sum by 10 and adding the current node's value
            sum = sum * 10 + root.val;
            return sum;
        }

        // Recursively calculate the sum for the left and right subtrees
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }
}
