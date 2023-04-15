package com.myleetcode.a07binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历-递归
 */
public class Tree01PreTraversal {
    public static void main(String[] args) {

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        perOrder(root, list);
        return list;
    }

    public void perOrder(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        list.add(cur.val);
        perOrder(cur.left, list);
        perOrder(cur.right, list);
    }
}
