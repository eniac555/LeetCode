package com.myleetcode.a08backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/5/10
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。解集不能包含重复的组合。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
 * <p>
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8, 所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
 */
public class Backtracking04 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();// 存放结果
        Arrays.sort(candidates); // 先进行排序---升序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path,
                             int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        //如果是一个集合来求组合的话，就需要startIndex (idx)
        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
