package com.wxx.java.sort;

import java.util.Arrays;

/*
 * 数组的冒泡排序的实现
 *
 */
public class BubbleSortTest {

    /**
     * 「冒泡排序 Bubble Sort」通过连续地比较与交换相邻元素实现排序。这个过程就像气泡从底部升到顶部一样，因此得名冒泡排序。
     * <p>
     * 我们可以利用元素交换操作模拟上述过程：从数组最左端开始向右遍历，依次比较相邻元素大小，如果“左元素 > 右元素”就交换它俩。遍历完成后，最大的元素会被移动到数组的最右端。
     *
     * 设输入数组长度为n，冒泡排序的步骤为：
     *
     * 1、首先，对n个元素执行“冒泡”，将数组的最大元素交换至正确位置，
     * 2、接下来，对剩余n-1个元素执行“冒泡”，将第二大元素交换至正确位置。
     * 3、以此类推，经过n-1轮“冒泡”后，前n-1大的元素都被交换至正确位置。
     * 4、仅剩的一个元素必定是最小元素，无需排序，因此数组排序完成。
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        for (int i = nums.length-2; i >0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                //若从未进入此循环，则表示前一个数总是比后一个数小
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

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
