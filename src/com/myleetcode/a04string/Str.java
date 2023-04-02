package com.myleetcode.a04string;

import java.util.HashMap;
import java.util.Map;

public class Str {
    public static void main(String[] args) {
        String s = "abcabc";
        int i = (s + s).indexOf(s, 1);
        //System.out.println(i);
        boolean b = repeatedSubstringPattern(s);
        //System.out.println(b);
        StringBuilder sb = new StringBuilder();
        /*Set<Integer> set1 = new HashSet<>();
        for (int integer : set1) {
            System.out.println(integer);
        }*/
        int[] arr = {1,9,8,11,12,5,6,7,4};
        int[] twoSum = twoSum(arr, 13);
        for (int j : twoSum) {
            System.out.println(j);
        }

    }


    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {//重复子串最长为原来一半，所以循环到1/2
            if (n % i == 0) {
                //找到每一种可能
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    //System.out.println("j: " + s.charAt(j));
                    //System.out.println("j-i: " + s.charAt(j - i));
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
            // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }
}
