package com.myleetcode.a03hash;


/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * ------------------------------------------------------------
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，
 * 组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 */
public class Hash06 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }


    //看到字母，首先想到定义26位的数组
    //遍历杂志，字母-‘a’对应数组索引，值用来存放字母出现次数  ++
    //遍历赎金信，字母-'a'，  数组元素值 --
    //遍历数组，出现负数就返回false
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] mag = magazine.toCharArray();
        char[] ran = ransomNote.toCharArray();
        for (char i : mag) {
            arr[i - 'a'] = arr[i - 'a'] + 1;
        }

        for (char i : ran) {
            arr[i - 'a'] = arr[i - 'a'] - 1;
        }
        for (int i : arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;

    }
}
