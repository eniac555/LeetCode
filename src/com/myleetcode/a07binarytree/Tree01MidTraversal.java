package com.myleetcode.a07binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历-递归
 */
public class Tree01MidTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list;
    }

    public void midOrder(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        midOrder(cur.left, list);
        list.add(cur.val);
        midOrder(cur.right, list);
    }
}
