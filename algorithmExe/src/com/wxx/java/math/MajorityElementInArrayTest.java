package com.wxx.java.math;

import java.util.*;

/**
 * @author wxxstar
 * @create 2023-08-08 20:05
 * <p>
 * https://leetcode.cn/problems/majority-element/
 * https://leetcode.cn/problems/majority-element-ii/description/
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 */
public class MajorityElementInArrayTest {

    /**
     * 找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素，所以最多有2个数
     * 选出两个候选人，如果发现合其中一个一样，则一样的计数加一
     * 都不一样才都减一，意味着只有三分之1的可以参与抵消，因此只有大于零的数才有可能是候选人
     * @param nums
     * @return
     */
    public List<Integer> majorityElementByMore(int[] nums) {


        int cand1 = nums[0];
        int count1 = 0;
        int cand2 = nums[0];
        int count2 = 0;
        //抵消阶段
        for (int n : nums) {
            if (cand1 == n) {
                count1++;
                continue;
            }
            if (cand2 == n) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                cand1 = n;
                count1++;
                continue;
            }

            if (count2 == 0) {
                cand2 = n;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        //计数阶段
        for (int n : nums) {
            if (n == cand1) {
                count1++;
                continue;
            }
            if (n == cand2) {
                count2++;
            }
        }

        int flag = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        if (count1 > flag) list.add(cand1);
        if (count2 > flag) list.add(cand2);

        return list;

    }


    public int majorityElement(int[] nums) {
        int consistant = nums[0];
        int times = 0;
        for (int n : nums) {
            if (n == consistant) {
                times++;
            } else if (times == 0) {
                consistant = n;
                times++;
            } else {
                times--;
            }
        }
        return consistant;
    }

    public int majorityElementByBF(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int halfLen = len / 2;
        for (int i = 0; i < len; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
                continue;
            }
            value = value + 1;
            if (value > halfLen) {
                return nums[i];
            }
            map.put(nums[i], value);
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElementInArrayTest test = new MajorityElementInArrayTest();
        System.out.println(test.majorityElementByMore(new int[]{3, 2, 3}));
    }
}