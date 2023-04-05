package com.myleetcode.a04string;


import java.util.*;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class String04 {
    public static void main(String[] args) {

    }


    //方法一：
    public static String reverseWords(String s) {
        //1.删除字符串里多余空格
        StringBuilder sb = removeEmpty(s);
        //2.翻转整个字符串
        reverseStr(sb, 0, sb.length() - 1);
        //3.翻转每个单词
        reverseEach(sb);
        return sb.toString();
    }

    //1.删除字符串里多余空格
    public static StringBuilder removeEmpty(String s) {
        //先从两头开始，去掉多余空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;//找到起始位置的第一个非空格
        }
        while (s.charAt(end) == ' ') {
            end--;//找到结束位置的第一个非空格
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                //sb.charAt(sb.length() - 1)表示的已经判断完成的字符串的最后一个字符
                //如果连续两个空格，他就不会append
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    //2.翻转整个字符串
    public static void reverseStr(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //3.翻转每个单词
    public static void reverseEach(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(end) != ' ') {
                end++;//找到每个单词的结束索引，执行翻转操作
            }
            reverseStr(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }


    //方法二：API
    //这能行吗
    public static String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    //方法三：队列
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}
