package com.wxx.java.datastructure;

import java.util.*;

/**
 * @author wxxstar
 * @create 2023-07-28 22:04
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumberTest {

    public int findRepeatNumberBySet(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            } else {
                set.add(n);
            }
        }
        return -1;
    }

    public int findRepeatNumberByHashMap(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>(nums.length);
        for (int n : nums) {
            if (map.containsKey(n)) {
                return n;
            } else {
                map.put(n, true);
            }
        }
        return -1;
    }


    public int findRepeatNumberByArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            int currNum = nums[i];
            if (currNum == 0) {
                if (zeroCount > 0) {
                    return 0;
                } else {
                    zeroCount++;
                    continue;
                }
            }
            if (temp[currNum] != 0) {
                return currNum;
            } else {
                temp[currNum] = currNum;
            }
        }
        return -1;
    }
}
