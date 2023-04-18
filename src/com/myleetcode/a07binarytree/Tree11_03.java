package com.myleetcode.a07binarytree;

import java.util.Stack;

/**
 * 判断平衡二叉树
 */
public class Tree11_03 {
    /**
     * 优化迭代法，针对暴力迭代法的getHeight方法做优化，
     * 利用TreeNode.val来保存当前结点的高度，这样就不会有重复遍历
     * 获取高度算法时间复杂度可以降到O(1)，总的时间复杂度降为O(n)。
     * 时间复杂度：O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;//把左节点都push进去
            }
            TreeNode inNode = stack.peek();
            if (inNode.right == null || inNode.right == pre) {// 右结点为null或已经遍历过
                if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
                    return false;// 输出
                }
                stack.pop();
                pre = inNode;
                root = null;// 当前结点下，没有要遍历的结点了
            } else {
                root = inNode.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
    }

    /**
     * 求结点的高度
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = root.left != null ? root.left.val : 0;
        int rightHeight = root.right != null ? root.right.val : 0;
        int height = Math.max(leftHeight, rightHeight) + 1;
        root.val = height;// 用TreeNode.val来保存当前结点的高度
        return height;
    }
}
