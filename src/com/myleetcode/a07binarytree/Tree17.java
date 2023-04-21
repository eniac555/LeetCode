package com.myleetcode.a07binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意: 你可以假设树中没有重复的元素。
 */
public class Tree17 {
    //以后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，反过来再切后序数组。
    //一层一层切下去，每次后序数组最后一个元素就是节点元素。

    Map<Integer, Integer> map;  // 方便根据数值查找位置

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // 用map保存中序序列的数值对应位置，根据后续的最后一个元素值在中序里找对应索引
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
        // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd,
                             int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
