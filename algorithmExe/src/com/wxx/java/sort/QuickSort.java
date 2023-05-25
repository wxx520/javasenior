package com.wxx.java.sort;

import java.util.Random;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 *
 * @author shkstart
 * 2018-12-17
 */
public class QuickSort {
    private static final Random random = new Random(System.currentTimeMillis());

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partitionByTwoWay(nums, left, right);

        quickSort(nums, left, pivotIndex - 1);//递归调用
        quickSort(nums, pivotIndex + 1, right);
    }

    /**
     * 分组函数，j为比pivot的组小的最后一个元素
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partitionByRandomLeft(int[] nums, int left, int right) {

        //random.nextInt(right-left+1)的随机区间为[0,(right-left+1)-1]=[0,right-left]
        //故randomLeftIndex的区间为：[left,right]
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

    /**
     * 双路快排
     * 循环不变量：
     * 循环前：
     * pivot = nums[left];
     * [left+1,le)<=pivot
     * (ge,right]>=pivot
     * 循环中：
     * * 当i遇到nums[le]<pivot,le++;否则在停下
     * * 当j遇到nums[ge]>pivot,ge--;否则停下
     * * 双方停下后交换swap(nums,ge,le);ge--,le++
     * * swap(nums,ge,left);
     * 循环结束：
     * * 当ge<=le时，遍历结束
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partitionByTwoWay(int[] nums, int left, int right) {

        //random.nextInt(right-left+1)的随机区间为[0,(right-left+1)-1]=[0,right-left]
        //故randomLeftIndex的区间为：[left,right]
        int randomLeftIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomLeftIndex);

        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        // all nums in nums[left+1,j)<pivot
        //all nums in nums(j,i)>pivot;
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    /**
     * 双路快排
     * 循环不变量：
     * 循环前：
     * i是遍历，left+1<=i<=gt
     * pivot = nums[left];
     * lt = left+1;
     * gt=right;
     * i=left+1;
     * 性质：
     * [left+1..lt)<pivot;
     * [lt..i)=pivot;
     * (gt..right]>pivot;
     * 循环中：
     * * 当i遇到nums[i]<pivot,lt++,swap(nums, i, lt),i++;
     * * 当i遇到nums[i]=pivot,i++;
     * * 当i遇到nums[i]>pivot, swap(nums,gt,i),gt--,i++;
     * 循环结束：
     * *i>gt,遍历结束swap(nums,lt,left);
     * 当i=gt时，[lt..gt)(gt..right];并未遍历完成
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static void quickSortByThreeWays(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //random.nextInt(right-left+1)的随机区间为[0,(right-left+1)-1]=[0,right-left]
        //故randomLeftIndex的区间为：[left,right]
        int randomLeftIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomLeftIndex);

        int pivot = nums[left];
        int i = left + 1;
        int gt = right;
        int lt = left + 1;
        //all nums in [left+1..lt)<pivot
        //all nums in [lt..i)=pivot
        //all nums in (gt..right]>pivot
        while (i<=gt){
            if(nums[i]<pivot){//交换到等于pivot的第一个位置
                swap(nums,lt,i);
                lt++;
                i++;
            }else if(nums[i]==pivot){//不变i++遍历下一个
                i++;
            }else {
                //nums[i]>pivot
                swap(nums,gt,i);//交换到大于pivot的第一个位置
                gt--;
                //i不能加1，因为i的位置已经换成了原来的nums[gt]还没被处理
            }
        }
        swap(nums,left,lt-1);//nums[lt]时等于pivot的，此时要和小于pivot的组合的最后一个元素交换使得[left..lt-1)都小于pivot

        quickSort(nums, left, lt - 2);//递归调用,nums[lt-1]=pivot
        quickSort(nums, gt-1, right);
    }

    /**
     * 分组函数，j为比pivot的组大的第一个元素
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition1(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left + 1;
        // all nums in nums[left+1..j)<pivot
        //all nums in nums[j..i)>pivot;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, j, i);
                j++;
            }
        }
        swap(nums, left, j - 1);
        return j - 1;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void quickSort(int[] data) {
        quickSortByThreeWays(data, 0, data.length - 1);
    }


    public static void main(String[] args) {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
