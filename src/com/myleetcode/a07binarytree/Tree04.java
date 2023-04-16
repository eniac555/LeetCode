package com.myleetcode.a07binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class Tree04 {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);//放入正真的根节点

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();//用于存放每一层的结果
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();//把根节点取出来
                itemList.add(tmpNode.val);//取出对应的值

                //再把根节点对应的两个子节点放进去，如果存在的话
                //此时是加在队列尾部，前面可能存在上一层未遍历的元素，用len进行计算
                //遍历完len个元素之后就全部是下一层的元素了
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;//每一层可能有多个根节点，逐个遍历
            }

            resList.add(itemList);
        }
    }


}
