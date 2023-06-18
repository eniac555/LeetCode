package com.myleetcode.a09greed;


/**
 * 定义二叉树树节点类
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
