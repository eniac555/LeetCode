package com.myleetcode.a04string;


/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class String03 {
    public static void main(String[] args) {

    }

    //扩充法，不用额外的空间，使用双指针
    public static String replaceSpace1(String s) {
        if (s == null) {
            return null;
        }
        //存放扩充的部分，又一个空格，就会多扩充两个空间
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");//两个空格
            }
        }
        if (sb.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s = s + sb.toString();
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        for (; left >= 0; left--) {
            if (arr[left] == ' ') {
                arr[right--] = '0';
                arr[right--] = '2';
                arr[right] = '%';
            } else {
                arr[right] = arr[left];
            }
            right--;
        }
        return new String(arr);
    }


    //常规方法，使用了额外的空间
    public String replaceSpace2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
