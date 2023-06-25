package com.myleetcode.a10dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eniac555
 * @date 2023/6/25
 * @description: 打家劫舍---第三版-----有点点难
 */
public class DP24 {

    // 3.动态规划去偷
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        // res 就是用来存储每个节点的状态，0--不偷   1---偷
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }


    // 1.递归去偷，超时
    public int rob2(TreeNode root) {
        if (root == null)
            return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            money += rob2(root.right.left) + rob2(root.right.right);
        }
        return Math.max(money, rob2(root.left) + rob2(root.right));
        // 这两个数分别表示：偷根节点的收益--不偷根节点(意味着可能偷根节点的左右孩子)的收益
    }


    // 2.递归去偷，记录状态
    // 执行用时：3 ms , 在所有 Java 提交中击败了 56.24% 的用户
    public int rob3(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robAction(root, memo);
    }

    int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int money = root.val;
        if (root.left != null) {
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if (root.right != null) {
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }

}
