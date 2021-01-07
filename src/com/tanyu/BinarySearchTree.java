package com.tanyu;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/12/27 2:40 下午
 */
public class BinarySearchTree {

    private static class TreeNode {
        private Integer val;

        private TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(Integer val) {
            this.val = val;
        }

        public TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }else {
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }else {
                TreeNode toDeleteTreeNode = findMin(root.right);
                root.val = toDeleteTreeNode.val;
                root.right = deleteNode(root.right, toDeleteTreeNode.val);
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);
        right.right = new TreeNode(7);
        root.left = left;
        root.right = right;

        deleteNode(root, 3);
    }
}
