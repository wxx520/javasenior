package com.wxx.java.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lhbac
 * @create 2023/6/1 9:16
 */
public class CountSmallerTest {

    /**
     * 暴力算法
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller0(int[] nums) {
        if (nums == null || nums.length < 2) {
            return Arrays.asList(0);
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int base = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < base) {
                    res[i]++;
                }
            }
        }
        List<Integer> resList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    /**
     * 归并排序
     * 升序的数组无翻转对
     * 降序的数组有可能有翻转对，
     * 对于已经分组的数组，左右的顺序互不影响，每个元素右侧比自己小的元素包含自己数组的和右侧数组之和
     * <p>
     * 故在归并排序的过程中就可以计算每个数组后面比自己小的元素总数
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length < 2) {
            return Arrays.asList(0);
        }
        int len = nums.length;
        int[] res = new int[len];
        int[] indexes = new int[len];//索引数组，针对索引数组排序
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        int[] temp = new int[len];
        countSmaller(nums, 0, len - 1, indexes, temp, res);
        List<Integer> resList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    private void countSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
        if (right - left < 16) {
            insertionSort(nums, left, right, indexes, res);
            return;
        }
        /*if (left >= right) {
            return;
        }*/
        int mid = (left + right) / 2;
        countSmaller(nums, left, mid, indexes, temp, res);
        countSmaller(nums, mid + 1, right, indexes, temp, res);
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {//优化
            return;
        }
        mergeAndCount(nums, left, mid, right, indexes, temp, res);
    }

    private void insertionSort(int[] nums, int left, int right, int[] indexes, int[] res) {
        for (int i = left + 1; i <= right; i++) {
            int tempIndex = indexes[i];
            int temp = nums[tempIndex];
            int j;
            for (j = i; j > left && nums[indexes[j-1]] > temp; j--) {
                res[indexes[j-1]]++;
                indexes[j] = indexes[j - 1];
            }
            indexes[j] = tempIndex;
        }
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > right) {
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else {//nums[i]>nums[j]
                indexes[k] = temp[j];
                j++;
            }

        }
    }

    @Test
    public void t1() {
        int[] arr = {-10000, -10000, -10000, -10000, -10000, -9999, -9999, -9999, -9999, -9999, -9998, -9998, -9998, -9998, -9998, -9997, -9997, -9997, -9997, -9997, -9996, -9996, -9996, -9996, -9996, -9995, -9995, -9995, -9995, -9995, -9994, -9994, -9994, -9994, -9994, -9993, -9993, -9993, -9993, -9993, -9992, -9992, -9992, -9992, -9992, -9991, -9991, -9991, -9991, -9991, -9990, -9990, -9990, -9990, -9990, -9989, -9989, -9989, -9989, -9989, -9988, -9988, -9988, -9988, -9988, -9987, -9987, -9987, -9987, -9987, -9986, -9986, -9986, -9986, -9986, -9985, -9985, -9985, -9985, -9985, -9984, -9984, -9984, -9984, -9984, -9983, -9983, -9983, -9983, -9983, -9982, -9982, -9982, -9982, -9982, -9981, -9981, -9981, -9981, -9981, -9980, -9980, -9980, -9980, -9980, -9979, -9979, -9979, -9979, -9979, -9978, -9978, -9978, -9978, -9978, -9977, -9977, -9977, -9977, -9977, -9976, -9976, -9976, -9976, -9976, -9975, -9975, -9975, -9975, -9975, -9974, -9974, -9974, -9974, -9974, -9973, -9973, -9973, -9973, -9973, -9972, -9972, -9972, -9972, -9972, -9971, -9971, -9971, -9971, -9971, -9970, -9970, -9970, -9970, -9970, -9969};
        int[] arr1 = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        int l1 = arr1.length;
        int[] indexes = new int[l1];
        int[] res = new int[l1];
        int[] temp = new int[l1];
        for (int i = 0; i < l1; i++) {
            indexes[i]=i;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(indexes));
        //insertionSort(arr1,0,l1-1,indexes,res);
        countSmaller(arr1,0,l1-1,indexes,temp,res);
        System.out.println(Arrays.toString(indexes));
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(arr1));
    }
}
