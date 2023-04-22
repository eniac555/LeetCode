package com.myleetcode.a07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class Tree31 {

    //根据图示，节点累加顺序是按照反中序遍历顺序累加的


    //递归--力扣
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    //代码随想
    int sum2;
    public TreeNode convertBST2(TreeNode root) {
        sum2 = 0;
        convertBST1(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum2 += root.val;
        root.val = sum2;
        convertBST1(root.left);
    }

}
