package com.wxx.java.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lhbac
 * @create 2023/5/26 15:50
 */
public class SortColorsTest {
    /**
     * 快速排序：三路快排
     * <p>
     * 循环不变量：将数分为三组，第一组均为0，第二组均为1，第三组均为2，所有数分完时达成目标
     * 初始化
     * int lt = left
     * int gt =right;
     * all nums in nums[left..lt)=0
     * all nums in nums[lt..i)=1
     * all nums in nums(gt..right]=2
     * <p>
     * 保持：
     * i为遍历，从left开始，>gt结束
     * 若nums[i]==0,和第二组的第一个元素交换(也是第一组结束的下一个元素)，swap(nums,i,lt),lt++, i++;
     * 若nums[i]==1，i++
     * 若nums[i]==2,和第三组的第一个元素的前一个元素交换，swap(nums,i,gt)，gt--;(此时i不能加1，因为i此时为之前的nums[gt],还未处理)；
     * 遍历结束后：所有的元素三组分成完成，
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int lt = 0;
        int gt = nums.length - 1;
        int j = 0;
        while (j <= gt) {
            if (nums[j] == 0) {
                swap(nums, j, lt);
                lt++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, gt);
                gt--;
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Test
    public void t1() {
        int[] test = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(test));
        sortColors(test);
        System.out.println(Arrays.toString(test));
    }
}
