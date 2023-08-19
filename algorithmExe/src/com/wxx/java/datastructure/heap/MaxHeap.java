package com.wxx.java.datastructure.heap;

/**
 * @author wxxstar
 * @create 2023-08-14 9:17
 * <p>
 * https://www.suanfa8.com/priority-queue/implement
 */
public class MaxHeap {

    private int[] data;
    // 当前堆中存储的元素的个数
    private int count;

    // 堆中能够存储的元素的最大数量（为简化问题，不考虑动态扩展）
    private int capacity;

    // 初始化最大堆
    public MaxHeap(int capacity) {
        // 初始化底层数组元素（ 0 号下标位置不存数据，这是为了使得通过父结点获得左右孩子有更好的表达式）
        data = new int[capacity + 1];
        count = 0;
    }

    /**
     * 传递一个数组，形成一个最大堆
     * 理解 heapify 是关键
     *
     * @param arr 待排序的数组元素
     */
    public MaxHeap(int[] arr) {
        int length = arr.length;
        data = new int[length + 1];
        for (int i = 0; i < length; i++) {
            data[i + 1] = arr[i];
        }
        // 添加一个元素，就要把 count 加 1 ，因为我们是一次性添加，所以就直接将 count 赋值为 length 就可以了
        // 这一步赋值千万别忘了
        count = length;
        // 理解这一步是关键 heapify
        for (int i = length / 2; i >= 1; i--) {
            siftDown(i);
        }
    }


    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值，返回堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int v) {
        if (count + 1 > capacity) {
            return;
        }
        data[count + 1] = v;
        count++;
        siftUp(count);
    }

    private void siftUp(int k) {
        while (k > 1 & data[k / 2] < data[k]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public int extractMax() {
        if (count < 0) {
            return Integer.MIN_VALUE;
        }
        int max = data[1];
        swap(1, count);
        count--;
        siftDown(1);
        return max;
    }

    private void siftDown(int h) {
        while (2 * h <= count) {
            int k = 2 * h;
            if (k + 1 <= count && data[k + 1] > data[k]) {
                k = k + 1;
            }
            if (data[h] < data[k]) {
                swap(h, k);
            } else {
                break;
            }
            h = k;
        }
    }

    private void swap(int source, int target) {
        int temp = data[source];
        data[source] = data[target];
        data[target] = temp;
    }
}
