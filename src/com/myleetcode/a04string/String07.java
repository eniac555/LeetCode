package com.myleetcode.a04string;


/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class String07 {
    public static void main(String[] args) {

    }

    //方法一：枚举法
    public static boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {//重复子串最长为原来一半，所以循环到1/2
            if (n % i == 0) {//找到每一种可能
                boolean match = true;
                for (int j = i; j < n; ++j) {
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



    //方法二：将两个s 连在一起，并移除第一个和最后一个字符。如果s 是该字符串的子串，那么s 就满足题目要求。
    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

}
