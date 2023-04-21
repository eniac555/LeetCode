package com.myleetcode.a07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求完全二叉树的节点个数
 */
public class Tree10 {


    // 通用递归解法，不管是不是完全二叉树都可以
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }


    //层序遍历
    public int countNodes2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();//不需要统计层数
            while (len > 0) {
                count++;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
        }
        return count;
    }

}
