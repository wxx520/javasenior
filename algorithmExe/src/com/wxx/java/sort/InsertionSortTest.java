package com.wxx.java.sort;

import java.util.Arrays;

/**
 * @author lhbac
 * @create 2023/5/24 16:32
 */
public class InsertionSortTest {
    /**
     * 插入排序的整体流程如下：
     * 1、初始状态下，数组的第 1 个元素已完成排序。
     * 2、选取数组的第 2 个元素作为 base ，将其插入到正确位置后，数组的前 2 个元素已排序。
     * 3、选取第 3 个元素作为 base ，将其插入到正确位置后，数组的前 3 个元素已排序。
     * 4、以此类推，在最后一轮中，选取最后一个元素作为 base ，将其插入到正确位置后，所有元素均已排序。
     * <p>
     * 循环自变量的性质：区间nums[0，i)里保存了输入数组的前i个元素，并且按照升序排序
     * 1、初始值：i=1，区间nums[0，i)里只有一个元素
     * 2、保持：把nums[i]插入区间nums[0，i)使得区间nums[0，i]有序，下一轮循坏开始之前保持了性质
     * 3、终止：区间nums[0，n)有序
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int base = nums[i],j=i-1;
            while (j>=0&&nums[j]>base){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = base;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        System.out.println(Arrays.toString(arr1));
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
