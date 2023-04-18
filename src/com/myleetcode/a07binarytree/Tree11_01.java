package com.myleetcode.a07binarytree;

/**
 * 判断平衡二叉树
 */
public class Tree11_01 {

    /**
     * 递归法
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //比较好理解的递归!!!!
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(helper(root.left) - helper(root.right)) > 1) {
            return false;
        }
        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        return Math.max(left, right) + 1;
    }


}
