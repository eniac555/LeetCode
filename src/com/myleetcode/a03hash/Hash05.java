package com.myleetcode.a03hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0。
 */
public class Hash05 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }


    /**
     * 1.首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
     * 2.遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 3.定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 4.在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，
     * 就用count把map中key对应的value也就是出 现次数统计出来。
     * 5.最后返回统计值 count 就可以了
     */

    // HashMap
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        //先遍历AB，统计出每两个元素的和，作为map的key，然后出现的次数作为key
        int temp;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                temp = nums1[i] + nums2[j];
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                temp = nums3[i] + nums4[j];
                if (map.containsKey(0 - temp)) {
                    count = map.get(0 - temp) + count;
                }
            }
        }
        return count;
    }
}
