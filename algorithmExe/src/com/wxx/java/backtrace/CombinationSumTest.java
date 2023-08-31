package com.wxx.java.backtrace;

import org.junit.Test;

import java.util.*;

/**
 * @author lhbac
 * @create 2023/8/28 12:38
 */
public class CombinationSumTest {

    private static final Random random = new Random(System.currentTimeMillis());

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        quickSort(candidates,0, len-1);
        if (len == 0 || candidates[0] > target) {
            return res;
        }

        dfs(candidates, target, 0, new ArrayDeque<Integer>(), res);
        return res;
    }

    /**
     * 从指定数组candidates 从头到尾选择一定数量的数，使得这些数之和sum等于target
     *
     * @param candidates 带选择数组
     * @param target     终止条件
     * @param sum        当前已经计算的和，后续操作要再该数基础上加
     * @param path       已经选择的数元素列表
     * @param res        将符合条件的数列表放入该结果中
     */
    private void dfs(int[] candidates, int target, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            int cNum = candidates[i];
            if (sum + cNum > target) {
                break;
            }

            if (!path.isEmpty() && path.peekLast() > cNum) {
                continue;
            }

            path.addLast(cNum);

            dfs(candidates, target, sum + cNum, path, res);

            path.removeLast();
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= 7) {
            insertionSort(nums, left, right);
            return;
        }
        int pivotIndex = partitionByTwoWay(nums, left, right);

        quickSort(nums, left, pivotIndex - 1);//递归调用
        quickSort(nums, pivotIndex + 1, right);


    }

    private int partitionByTwoWay(int[] nums, int left, int right) {
        int randomLeftIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomLeftIndex);

        int pivot = nums[left];
        int j = left;
        // all nums in nums[left+1,j)<pivot
        //all nums in nums(j,i)>pivot;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void insertionSort(int[] nums, int left, int right) {
        if (left>=right) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }


    @Test
    public void t1() {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        int[] arr = {2, 3, 5,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
