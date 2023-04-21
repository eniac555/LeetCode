package com.myleetcode.a07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n叉树最大深度
 */
public class Tree08 {


    //层序遍历
    public int maxDepth1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();//需要统计层数，得分层遍历
            while (len > 0) {
                Node node = queue.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) {
                        queue.offer(node.children.get(i));
                    }
                }
                len--;
            }
        }
        return depth;
    }


    //递归遍历
    public int maxDepth2(Node root) {
        if (root == null) return 0;

        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth2(child));
            }
        }

        return depth + 1; //中节点
    }
}
