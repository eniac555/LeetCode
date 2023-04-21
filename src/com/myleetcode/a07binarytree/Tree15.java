package com.myleetcode.a07binarytree;

import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class Tree15 {

    //递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {      // 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }


    //简洁版递归
    public boolean hasPathSum2(TreeNode root, int targetSum) {

        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }


    //层序遍历迭代
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        //存储节点
        Stack<TreeNode> stack1 = new Stack<>();
        //存储当前节点目前的累加和
        Stack<Integer> stack2 = new Stack<>();
        if (root == null) return false;
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int len = stack1.size();//没必要，不用统计第几层，深度或者高度
            for (int i = 0; i < len; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                //满足条件，返回true
                if (node.left == null && node.right == null && sum == targetSum) return true;
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
            }
        }
        return false;
    }
}
