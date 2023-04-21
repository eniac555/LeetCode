package com.myleetcode.a07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 */
public class Tree07 {


    //递归法
    int maxnum = 0;

    public int maxDepth1(TreeNode root) {
        ans(root, 0);
        return maxnum;
    }

    //递归求解最大深度
    void ans(TreeNode tr, int tmp) {
        if (tr == null) return;
        tmp++;
        maxnum = maxnum < tmp ? tmp : maxnum;
        ans(tr.left, tmp);
        ans(tr.right, tmp);
        tmp--;
    }



    //层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();//需要统计层数，所以得分层
            depth++;
            while (len > 0) {
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
        return depth;
    }

}
