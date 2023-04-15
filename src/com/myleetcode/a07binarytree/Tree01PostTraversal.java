package com.myleetcode.a07binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree01PostTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }


    public void postOrder(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        postOrder(cur.left, list);
        postOrder(cur.right, list);
        list.add(cur.val);
    }
}
