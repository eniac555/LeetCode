package com.myleetcode.a03hash;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Hash02 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] intersection = intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }


    //主要用了HashSet，里面的contains(k)，判断set集合里面有没有这个key k
    //遍历第一个数组加到set1，遍历第二个数组，如果这个key在set1里面也存在，把这个key加到set2
    //循环结束，把set2转成数组返回
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //遍历第一个数组加到set1
        for (int k : nums1) {
            set1.add(k);
        }
        //遍历第二个数组，如果这个key在set1里面也存在，把这个key加到set2
        for (int k : nums2) {
            if (set1.contains(k)) {
                set2.add(k);
            }
        }
        //把set2转成数组返回
        int[] arr = new int[set2.size()];
        int j = 0;
        for (int i : set2) {
            arr[j++] = i;
        }
        return arr;
    }
}
