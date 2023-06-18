package com.myleetcode.a09greed;

import java.util.Arrays;

/**
 * @author eniac555
 * @date 2023/6/16
 * @description:
 */
public class Greed13 {

    //先按照右边元素进行排序
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            } else {
                count++;
            }
        }
        return intervals.length - count;
    }


    //先按照左边元素进行排序，个人倾向于这个
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            return Integer.compare(a[0],b[0]);
        });

        int remove = 0;
        int pre = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(pre > intervals[i][0]) {
                remove++;
                pre = Math.min(pre, intervals[i][1]);
            }
            else pre = intervals[i][1];
        }
        return remove;
    }
}
