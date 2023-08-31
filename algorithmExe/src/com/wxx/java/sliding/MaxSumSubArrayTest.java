package com.wxx.java.sliding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhbac
 * @create 2023/8/25 19:15
 */
public class MaxSumSubArrayTest {

    public int max(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        int ret = -1;
        int lastEnd = 0;

        int i = 0;
        for (; i < len; i++) {
            Integer end = map.get(nums[i]);
            if (end != null && end > i) {
                lastEnd = end;
                ret = sum(nums, i, end);
                break;
            }
        }

        i++;
        int decrease = 0;
        int increase = 0;
        for (; i < len; i++) {
            decrease += nums[i - 1];
            Integer end = map.get(nums[i]);
            if (end != null && end > i && end > lastEnd) {
                increase += sum(nums, lastEnd + 1, end);

                if (increase >= decrease) {
                    ret = ret + increase - decrease;
                    decrease = 0;
                    increase = 0;
                }

                lastEnd = end;
            }
        }
        return ret;
    }

    private int sum(int[] nums, int l, int r) {
        int ret = 0;
        for (int i = l; i <= r; i++) {
            ret += nums[i];
        }
        return ret;
    }

    @Test
    public void t1() {
        System.out.println(max(new int[]{1, 2, 3}));
        System.out.println(max(new int[]{1, 2, 3, 6, 6, 6, 1, 3, 3, 4}));
        System.out.println(max(new int[]{1, 2, 2, 2, 2, 2, 2}));
    }
}
