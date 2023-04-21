package com.myleetcode.a07binarytree;

import java.util.Stack;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class Tree23 {

    //和前面判断是不是二叉搜索树几乎一样，只需改 中 部分
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //找到最左的叶子节点
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null) {
                result = Math.min(result, pop.val - pre.val);
            }
            pre = pop;
            root = pop.right;// 右
        }
        return result;
    }


    //递归
    //这个递归挺好理解的
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }


}
