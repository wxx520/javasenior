package com.wxx.java.sort;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/6/1 22:16
 */
public class IsStraightTest {

    /**
     * 判断是否递增，0不纳入计算
     */
    public boolean isStraight(int[] nums) {
        int[] arr = new int[14];
        int max = -1;
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            if (arr[num] != 0) {
                return false;
            }
            arr[num] = num;
            if (max == -1) {
                max = num;
                min = num;
                continue;
            }
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        return max - min < 5;
    }

    @Test
    public void t() {
        int[] arr = {0, 0, 8, 5, 4};
        System.out.println(isStraight(arr));
    }
}
