package eshaan.learning.dsa.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return sortedListToBST(list, 0, list.size()-1);

    }

    public void inorderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, sortedList);  // Traverse left subtree
        sortedList.add(root.val);                 // Add current node's value
        inorderTraversal(root.right, sortedList); // Traverse right subtree
    }

    // Step 2: Convert sorted list to balanced BST
    public TreeNode sortedListToBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2; // Find middle element
        TreeNode node = new TreeNode(sortedList.get(mid)); // Middle element becomes root

        // Recursively build left and right subtrees
        node.left = sortedListToBST(sortedList, start, mid - 1);
        node.right = sortedListToBST(sortedList, mid + 1, end);

        return node;
    }

}
