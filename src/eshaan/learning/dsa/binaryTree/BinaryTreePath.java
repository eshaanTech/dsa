package eshaan.learning.dsa.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            findPaths(root, "", paths);
        }
        return paths;

    }
    private void findPaths(TreeNode node, String path, List<String> paths) {
        // If the current node is a leaf, append the path to the list
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
        }

        // If the current node has a left child, continue the path
        if (node.left != null) {
            findPaths(node.left, path + node.val + "->", paths);
        }

        // If the current node has a right child, continue the path
        if (node.right != null) {
            findPaths(node.right, path + node.val + "->", paths);
        }
    }

}
