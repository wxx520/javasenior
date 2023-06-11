package com.wxx.java.sort;

import org.junit.Test;

import java.util.Random;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 *
 * @author lhbac
 * @create 2023/6/1 21:37
 */
public class MinCombinationNumberTest {
    private static final Random random = new Random(System.currentTimeMillis());

    /**
     * 快速排序
     * <p>
     * 基于字符串比较
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] numStrs = new String[len];
        for (int i = 0; i < len; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        quickSort(numStrs, 0, len - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(numStrs[i]);
        }
        return sb.toString();
    }

    private void insertionSort(String[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            String temp = nums[i];
            int j;
            for (j = i; j > left && (nums[j - 1] + temp).compareTo(temp + nums[j - 1]) > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }

    }

    private void quickSort(String[] nums, int left, int right) {
        /*if (left >= right) {
            return;
        }*/
        if (right - left < 16) {
            insertionSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private int partition(String[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        String pivot = nums[left];
        int j = left + 1;


        // all nums in nums[left+1,j)<=pivot
        //all nums in nums[j,i)>pivot;
        for (int i = left + 1; i <= right; i++) {
            if ((nums[i] + pivot).compareTo(pivot + nums[i]) <= 0) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, left, j - 1);
        return j - 1;
    }

    private void swap(String[] nums, int left, int randomIndex) {
        String temp = nums[left];
        nums[left] = nums[randomIndex];
        nums[randomIndex] = temp;
    }

    @Test
    public void t() {
        String s = "321";
        String s1 = "123";
        System.out.println(s1.compareTo(s));
        System.out.println(s1.compareTo(s1));
        System.out.println(s.compareTo(s1));
    }
}
