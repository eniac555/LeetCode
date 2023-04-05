package com.myleetcode.a04string;


/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * <p>
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * <p>
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class String06 {
    public static void main(String[] args) {

    }

    /**
     * 基于窗口滑动的算法
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //needle为空，返回0
        if (n == 0) {
            return 0;
        }
        //needle长度大于haystack，返回-1
        if (m < n) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < m - n + 1) {
            //找到长串中第一个和子串相等的元素
            while (i < m && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == m) {//没有首字母相等，返回-1，不用继续找了
                return -1;
            }
            //找到首字符相同的位置后，遍历后面的字符
            i++;
            j++;
            while (i < m && j < n && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {//找到了
                return i - j;
            } else {//未找到，i和j回退，再次遍历
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
