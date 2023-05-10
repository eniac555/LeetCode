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
public class Backtracking06 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2( int[] candidates, int target ) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort( candidates );
        backTracking( candidates, target, 0 );
        return res;
    }

    private void backTracking( int[] candidates, int target, int start ) {
        if ( sum == target ) {
            res.add( new ArrayList<>( path ) );
            return;
        }
        for ( int i = start; i < candidates.length && sum + candidates[i] <= target; i++ ) {
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if ( i > start && candidates[i] == candidates[i - 1] ) continue;

            sum += candidates[i];
            path.add( candidates[i] );
            // i+1 代表当前组内元素只选取一次
            backTracking( candidates, target, i + 1 );

            int temp = path.getLast();
            sum -= temp;
            path.removeLast();
        }
    }
}
