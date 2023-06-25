package com.myleetcode.a10dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/6/25
 * @description: 多重背包
 */
public class DP21 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int[] nums = {2, 3, 2};
        int bagWeight = 10;
        System.out.println(multiPack(weight, value, nums, bagWeight));
        testMultiPack1();
    }

    private static int multiPack(int[] weight, int[] value, int[] nums, int bagWeight) {

        List<Integer> newWeight = new ArrayList<>();
        for (int i : weight) {
            newWeight.add(i);
        }
        List<Integer> newValue = new ArrayList<>();
        for (int i : value) {
            newValue.add(i);
        }

        for (int i = 0; i < nums.length; i++) {//这里修改了nums数组，最终的数组变成了全1， 但也用不到了，没有影响
            while (nums[i] > 1) {
                newWeight.add(newWeight.get(i));
                newValue.add(newValue.get(i));
                nums[i]--;
            }
        }

        //0-1背包，先遍历物品，再倒序遍历背包
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < newWeight.size(); i++) {
            for (int j = bagWeight; j >= newWeight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - newWeight.get(i)] + newValue.get(i));
            }
        }

        return dp[bagWeight];
    }


    //-----------------------------------下面是别人的----------------------------------------
    public static void testMultiPack1() {
        // 版本一：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) { // 遍历物品
            for (int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }


    public void testMultiPack2() {
        // 版本二：改变遍历个数
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int[] nums = new int[]{2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 变化的遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }


}
