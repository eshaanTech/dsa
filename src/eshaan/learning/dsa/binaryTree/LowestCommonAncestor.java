package eshaan.learning.dsa.binaryTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if(leftTree!=null & rightTree!=null){
            return root;
        }
        return leftTree!=null?leftTree : rightTree;
    }
}
