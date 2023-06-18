package com.myleetcode.a09greed;

/**
 * @author eniac555
 * @date 2023/6/18
 * @description:
 */
public class Greed16 {

    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }

    /**
     * 上面方法创建了String数组，多次使用Integer.parseInt了方法，这导致不管是耗时还是空间占用都非常高，用时12ms，
     * 下面这个版本在char数组上原地修改，用时1ms
     */

    public int monotoneIncreasingDigits2(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();

        //找到最靠前（左）的应该改成9的位置
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        //根据前面找到的位置，把后面每一位元素都置为9
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
