package com.wxx.java.datastructure.list;

import org.junit.Test;

import java.util.*;

/**
 * @author lhbac
 * @create 2023/8/20 12:50
 */
public class FindTopKFrequentTest {

    private static final Random random = new Random(System.currentTimeMillis());

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len <= k) {
            return nums;
        }
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int cn = nums[i];
            Integer v = occurrences.get(cn);
            if (v == null) {
                occurrences.put(cn, 1);
            } else {
                occurrences.put(cn, 1 + v);
            }
        }

        int occSize = occurrences.size();
        if (occSize <= k) {
            Set<Integer> set = occurrences.keySet();
            int[] res = new int[occSize];
            int i = 0;
            for (int v : set) {
                res[i] = v;
                i++;
            }
            return res;
        }
        //根据频率分治快排
        int[][] values = new int[occSize][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            values[i] = new int[]{entry.getKey(), entry.getValue()};
        }
        int[] res = qsort(values, 0, occSize - 1, k);
        return res;
    }

    private int[] qsort(int[][] values, int left, int right, int targetIndex) {

        int randomLeftIndex = left + random.nextInt(right - left + 1);
        swap(values, left, randomLeftIndex);
        int pivotOcc = values[left][1];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if(values[i][1]<pivotOcc){
                index++;
                swap(values,index,i);
            }
        }
        swap(values,left,index);
        if(index==right-targetIndex){
            int[] res = new int[targetIndex];
            for (int i = index; i <=right ; i++) {
                res[i-index]=values[i][0];
            }
        }else if(index<index-targetIndex){
            qsort(values,index,right,targetIndex);
        }else {
            qsort(values,left,index,targetIndex);
        }

        //快速排序
        return null;
    }

    private int partitionByRandomLeft(int[][] values, int left, int right, int targetIndex) {
        if (left >= right) {
            return right;
        }
        int randomLeftIndex = left + random.nextInt(right - left + 1);
        swap(values, left, randomLeftIndex);
        int pivotOcc = values[left][1];
        int res = left;
        //(left,res]<pivotOcc
        //(res,i]>=pivotOcc;
        for (int i = left + 1; i <= right; i++) {
            if(values[i][1]<pivotOcc){
                res++;
                swap(values,res,i);
            }
        }
        return res;
    }

    private void swap(int[][] values, int a, int b) {
        int[] temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    public int[] topKFrequentByPriorityQueue(int[] nums, int k) {
        int len = nums.length;
        if (len <= k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int cn = nums[i];
            Integer v = map.get(cn);
            if (v == null) {
                map.put(cn, 1);
            } else {
                map.put(cn, 1 + v);
            }
        }

        if (map.size() <= k) {
            Set<Integer> set = map.keySet();
            int[] res = new int[set.size()];
            int i = 0;
            for (int v : set) {
                res[i] = v;
                i++;
            }
            return res;
        }
        PriorityQueue<int[]> minQueue = new PriorityQueue<>(k, Comparator.comparingInt(arr -> arr[1]));
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k) {
                minQueue.offer(new int[]{entry.getKey(), entry.getValue()});
                i++;
            } else {
                int[] min = minQueue.peek();
                if (entry.getValue() > min[1]) {
                    minQueue.poll();
                    minQueue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = minQueue.poll()[0];
        }
        return res;
    }

    @Test
    public void t1() {
        System.out.println(Arrays.toString(topKFrequentByPriorityQueue(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
