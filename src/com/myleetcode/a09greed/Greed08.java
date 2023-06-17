package com.myleetcode.a09greed;

/**
 * @author eniac555
 * @date 2023/5/29
 * @description: 加油站
 */
public class Greed08 {

    //不算贪心
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);//依照顺序遍历每一个加油站剩下的汽油，并求和
            min = Math.min(sum, min);
        }

        //情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
        if (sum < 0) return -1;

        //情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，
        //如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
        if (min >= 0) return 0;

        //情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }

        return -1;
    }


    //贪心算法
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        //每个加油站的剩余量rest[i]为gas[i] - cost[i]。
        //i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，
        //说明[0, i]区间都不能作为起始位置，因为这个区间选择任何一个位置作为起点，
        //到i这里都会断油，那么起始位置从i+1算起，再从0计算curSum。
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }
}
