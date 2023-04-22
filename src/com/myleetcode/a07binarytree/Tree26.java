package com.myleetcode.a07binarytree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Tree26 {

    /*
    核心：从上向下去递归遍历，第一次遇到 cur节点是数值在[p, q]区间中，那么cur就是 p和q的最近公共祖先。
     */

    //递归---极其好理解
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }


    //迭代法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val > root.val && q.val > root.val) root = root.right;
            else if (p.val < root.val && q.val < root.val) root = root.left;
            else break;
        }
        return root;
    }
}
