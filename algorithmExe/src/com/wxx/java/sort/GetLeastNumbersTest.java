package com.wxx.java.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lhbac
 * @create 2023/5/26 17:08
 */
public class GetLeastNumbersTest {

    private static final Random random = new Random(System.currentTimeMillis());


    /**
     * 快排的思想：
     * int index = partition(arr, left, right);
     * left=0;
     * right=arrLen-1;
     * <p>
     * 分组时，index左边的数不大于arr[index],右边的数不小于arr[index]
     * 如果index=k-1：则[0,k-1/index]<=[index,arrLen-1]即为题目要求
     * 如果index>k-1，此时前k个最小的数一定在[0,index]中，此时放弃[index+1,arrLen-1],
     * 继续对区间[0,index]进行分组，int index = partition(arr, left, index-1);
     * 如果index<k-1，此时[0,index]一定都时前K个最小的数，此时放弃[0，index],
     * 继续对区间[index,arrLen-1]进行分组，int index = partition(arr, index+1, arrLen-1);
     * 直至 index=k-1;
     * <p>
     * 结束
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr == null) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }

        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (true) {
            int partitionIndex = partition(arr, left, right);
            if (partitionIndex == k-1) {
                break;
            } else if (partitionIndex < k-1) {
                left = partitionIndex + 1;
            } else {
                right = partitionIndex - 1;
            }
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partition(int[] arr, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(arr, left, randomIndex);

        int pivot = arr[left];
        int j = left;
        // all nums in nums[left+1,j]<pivot
        //all nums in nums(j,i)>=pivot;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, left, j);
        return j;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Test
    public void t1() {
        int[] a1 = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(getLeastNumbers(a1, 4)));
    }
}
