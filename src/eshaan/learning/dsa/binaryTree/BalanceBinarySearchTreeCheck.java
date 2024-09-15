package eshaan.learning.dsa.binaryTree;

public class BalanceBinarySearchTreeCheck {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        return (Math.abs(getHeight(root.left)-getHeight(root.right))<2 && isBalanced(root.left) && isBalanced(root.right));

    }

    int getHeight(TreeNode node){
        if(node==null)
            return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
