package com.myleetcode.a07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的 最后一行 找到最左边的值
 */
public class Tree14 {

    //层序遍历
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                //每一层的第一个节点的值都拿出来，最后一次循环的值就是想要的结果
                if (i == 0) result = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

}
