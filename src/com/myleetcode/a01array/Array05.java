package com.myleetcode.a01array;


/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Array05 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);


    }


    //坚持每条边左闭右开的原则
    public static int[][] generateMatrix(int n) {
        int loop = 1;//控制循环次数，就是转的圈数
        int start = 0;//第一圈开始时的起始点(0,0)
        int[][] result = new int[n][n];//创建空数组用于存放结果
        int count = 1;//计算矩阵中元素的值的
        int i = 0;
        int j = 0;
        while (loop <= n / 2) {//从1开始，偶数的话例如4，会执行两个圈，奇数例如3会执行1次，再跳到最后面去
            for (i = start; i < n - loop; i++) {// 模拟上侧从左到右
                result[start][i] = count;
                count++;
            }
            for (j = start; j < n - loop; j++) {// 模拟右侧从上到下
                result[j][i] = count;
                count++;
            }
            for (; i >= loop; i--) {// 模拟下侧从右到左
                result[j][i] = count;
                count++;
            }
            for (; j >= loop; j--) {//模拟左侧从下到上
                result[j][i] = count;
                count++;
            }
            start++;//新的一圈的起始点(1,1)  (2,2)
            loop++;//开始新的一圈
        }
        if (n % 2 == 1) {//奇数的话，最后一圈只剩单独一个元素
            result[start][start] = count;
        }

        return result;

    }
}
