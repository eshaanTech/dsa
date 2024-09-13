package eshaan.learning.dsa.binaryTree;


public class MaximumPathSumBinaryTree {
    int maxSum = Integer.MIN_VALUE;
    public int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Calculate max path sum of the left and right subtrees
        int leftSum = Math.max(0, calculatePathSum(node.left));  // Ignore negative paths
        int rightSum = Math.max(0, calculatePathSum(node.right)); // Ignore negative paths
        // Update the global maximum sum if the current path is greater
        int currentSum = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentSum);
        // Return the maximum sum path that includes the current node and one of its subtrees
        return node.val + Math.max(leftSum, rightSum);
    }
    public int maximumPathSumBinaryTree(TreeNode node){
        calculatePathSum(node);
        return maxSum;
    }
    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumPathSumBinaryTree solution = new MaximumPathSumBinaryTree();
        System.out.println("Maximum Path Sum: " + solution.maximumPathSumBinaryTree(root));  // Output: 42
    }
}
