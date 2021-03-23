package com.tanyu;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2021/2/17 10:14 上午
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {

     }
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}