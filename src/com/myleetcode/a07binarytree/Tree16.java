package com.myleetcode.a07binarytree;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出 所有 从根节点到叶子节点 路径总和等于给定目标和的路径
 */
public class Tree16 {

    //递归
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 非空判断

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetSum 的路径
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetSum，返回
        }

        if (root.left != null) {
            preorderdfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preorderdfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
    }


    //迭代
    List<List<Integer>> ret = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) return ret;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<>(temp));
    }


    //深度优先遍历
    List<List<Integer>> ret2 = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum3(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret2;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret2.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }


    //层序遍历迭代
    public List<List<Integer>> pathSum4(TreeNode root, int targetSum) {
        //存结果
        List<List<Integer>> result = new ArrayList<>();
        //存路径上的每个节点和其父节点，即所有的父子关系
        Map<TreeNode, TreeNode> map = new HashMap<>();
        if (root == null) return result;
        //存储节点
        Queue<TreeNode> queue1 = new LinkedList<>();
        //存储当前节点目前的累加和
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(root);
        queue2.offer(0);

        //层序遍历的部分设置len是因为要分层返回节点的值，这里不需要
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            int sum = queue2.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    //满足条件，执行插入结果的代码
                    List<Integer> temp = new LinkedList<>();
                    while (node != null) {
                        temp.add(node.val);
                        node = map.get(node);
                    }
                    Collections.reverse(temp);
                    result.add(new LinkedList<>(temp));
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queue1.offer(node.left);
                    queue2.offer(sum);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue1.offer(node.right);
                    queue2.offer(sum);
                }
            }
        }
        return result;

    }


}
