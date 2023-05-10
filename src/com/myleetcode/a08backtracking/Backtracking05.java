package com.myleetcode.a08backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/5/10
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Backtracking05 {

    //使用标记数组，用来记录当前数字是否被使用
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);

        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
