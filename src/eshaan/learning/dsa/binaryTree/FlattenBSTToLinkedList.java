package eshaan.learning.dsa.binaryTree;

public class FlattenBSTToLinkedList {
    public void flatten(TreeNode root){
        if(root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode current = root;
        while(current.right !=null){
            current = current.right;
        }
        current.right = temp;
    }

    public static void main(String[] args){

    }
}
