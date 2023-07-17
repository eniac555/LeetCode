package com.myleetcode.a14others;

/**
 * @author eniac555
 * @date 2023/7/5
 * @description: 移动0
 */
public class A04array {

    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    示例:
    输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
    说明:
    必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        //快慢指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
