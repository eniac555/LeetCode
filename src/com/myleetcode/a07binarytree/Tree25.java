package com.myleetcode.a07binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Tree25 {

    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null && left == null) return null;
        else if (right != null && left != null) return root;
        //root可能不是真正的root，而是遍历过程中的root
        else if (right != null && left == null) return right;
        else return left;
    }


    //递归，和上面一模一样的
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        } else if (left == null && right != null) { // 若找到一个节点
            return right;
        } else if (left != null && right == null) { // 若找到一个节点
            return left;
        } else { // 若找到两个节点
            return root;
        }
    }



    //存储父节点的迭代法----这个好理解
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);//深度优先遍历把节点和值放进map里面
        while (p != null) {
            //顺着p往上回溯，记录其所有祖先
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            //在遍历过的p的祖先里面找q或者q的祖先
            if (visited.contains(q.val)) {
                //找到就返回
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


}
