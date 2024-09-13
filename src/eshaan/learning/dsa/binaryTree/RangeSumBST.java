package eshaan.learning.dsa.binaryTree;

import java.util.Stack;

public class RangeSumBST {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode node, int low, int high){
        if(node!=null){
            if(low<=node.val && node.val <= high){
                sum+=node.val;
            }
            //traverse left
            if(low<=node.val){
                dfs(node.left, low, high);
            }
            //traverse right
            if(node.val<=high){
                dfs(node.right, low, high);
            }
        }

    }

    public int rangeSumBSTStack(TreeNode root, int low, int high) {
        int ans=0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                if(low<=node.val && node.val <= high){
                    ans+=node.val;
                }
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return ans;
    }

}
