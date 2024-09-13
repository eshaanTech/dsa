package eshaan.learning.dsa.binaryTree;

public class ValidateBST {
    /*
    Valid BST: all root node has left node less than root and right node is greater then the root
    we can perfrom DFS on left and DFS on right - if both left and right are valid - BST is valid
    we will have to additionally pass the low and high value to compare against the current node
     */
    public boolean validBST(TreeNode root){
        //since this is root no low or high are extablisehed yet
        return validBST(root, null, null);
    }
    private boolean validBST(TreeNode node, Integer low, Integer high){
        //null is valid bst
        if(node==null)
            return true;
        //check the condition
        if(low!=null && low>=node.val || high!=null && node.val >= high){
            return false;
        }
        return (validBST(node.left, low, node.val) && validBST(node.right, node.val, high));
    }
}
