package com.myleetcode.a03hash;


import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。   ！！！！！注意无限循环就变不成 1
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * ------------------------------------------------------------
 * 输入：19  输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Hash03 {
    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {//出现相同的意味着出现循环了，此时就跳出while，判断n是否为1
            //题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，重复出现就说明不是快乐数
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;//得到每一位，个十百千万...
            sum = sum + temp * temp;//求和
            n = n / 10;
        }
        return sum;
    }
}
