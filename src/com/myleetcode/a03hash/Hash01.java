package com.myleetcode.a03hash;


/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 就是判断s和t的字符以及出现次数是否相等
 */
public class Hash01 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    //字典法，26个字母对应26位的数组，遍历第一个字符串，以'a'的差作为数组索引，++记录出现次数
    //同理，另一个字符串执行--，遍历数组只要有非零值，返回false
    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
            // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符
                return false;
            }
        }
        return true;
    }
}
