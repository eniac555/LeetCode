package com.myleetcode.a04string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class String02 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));
    }

    public static String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i = i + 2 * k) {
            int start = i;//每个小区间里面的起点
            int end = Math.min(str.length - 1, start + k - 1);//确定每一步的大小
            //如果总长度大于2*k*i+k，则end=2*k*i+k，对应如果剩余字符小于 2k 但大于或等于 k 个
            //如果总长度小于2*k*i+k，对应剩余字符少于 k 个的情况
            while (start < end) {//在小区间内进行翻转
                char temp = str[end];
                str[end] = str[start];
                str[start] = temp;
                end--;
                start++;
            }
        }
        return new String(str);
    }
}
