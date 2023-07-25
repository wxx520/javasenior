package com.wxx.java.sort;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 * 1 <= s.length <= 5 * 105
 * s 由大小写英文字母和数字组成
 *
 * @author lhbac
 * @create 2023/5/29 22:22
 */
public class CharFrequencySortTest {

    /**
     * 遍历s，将出现的字符以及字符出现的次数放入
     * Map<Char,Int>中，并根据cha的数量放入Set<Char>[]中，次数相同的字符放入数组索引相同的位置，并从原来的位置中清除
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int maxFreq = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int cFreq = 1;
            //更新map
            if (countMap.containsKey(c)) {
                cFreq = countMap.get(c) + 1;
                countMap.put(c, cFreq);
            } else {
                countMap.put(c, cFreq);
            }
            maxFreq = Math.max(maxFreq, cFreq);
        }

        StringBuilder[] countSet = new StringBuilder[maxFreq];
        for (int i = 0; i < countSet.length; i++) {
            countSet[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> c : countMap.entrySet()) {
            int cCount = c.getValue();
            char cKey = c.getKey();
            StringBuilder sets = countSet[cCount - 1];
            for (int i = 0; i < cCount; i++) {
                sets.append(cKey);
            }
        }
        //逆序打印数组
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = maxFreq - 1; i >= 0; i--) {
            stringBuffer.append(countSet[i]);
        }

        return stringBuffer.toString();
    }

    /**
     * 注意到题目中的说明： s 由大小写英文字母和数字组成。所以 s 的种类是有限的，有
     * 26×2+10=72种，而 s 的长度最大是5 * 105，因此 s 中有大量重复的值，这一点提示我们可以使用「三路快排」，代码其实和「三路快排」是一样的，在编码的时候清楚变量的定义就容易写对；
     * <p>
     * 循环不变量性质
     * 初始化：
     * i为遍历值;
     * pivot = freqs[left];
     * lt = left+1;
     * i=left+1;
     * gt =right;
     * [left+1,lt)<pivot
     * [lt,i)=pivot
     * (gt,right]>pivot
     * <p>
     * 保持：
     * 若freqs[i]<pivot:swap(freq,i,lt),lt++,i++;
     * 若freqs[i]=pivot：i++;
     * 若freqs[i]>pivot:swap(freq,i,gt),gt--;
     * 当i>gt循环终止，数组遍历完成，分组完成
     * 继续下一次分组
     * <p>
     * 结束：
     *
     * @param s
     * @return
     */

    private final static Random random = new Random(System.currentTimeMillis());

    private int[] freq;

    public String frequencySortByQuickSort(String s) {
        freq = new int[128];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            freq[c]++;
        }

        quickSort(charArray, 0, s.length() - 1);
        return new String(charArray);
    }

    private void quickSort(char[] charArray, int left, int right) {
        if(left>=right){
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(charArray, left, randomIndex);
        int pivot = charArray[left];
        int lt = left + 1;
        int gt = right;
        //all in freq[left+1..lt)>pivot
        //all in freq[lt..i)=pivot
        //all in freq(gt..right]<pivot
        int i = left+1;
        while (i<=gt){
            if (freq[charArray[i]] > freq[pivot]) {
                swap(charArray, i, lt);
                lt++;
                i++;
            } else if (charArray[i] == pivot) {
                i++;
            } else {
                // nums[i] > pivot
                swap(charArray, i, gt);
                gt--;
            }
        }
        swap(charArray,left,lt-1);
        quickSort(charArray,left,lt-1);
        quickSort(charArray,gt+1,right);

    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

    @Test
    public void t1() {

        String s = "loveleetcode";
        System.out.println(frequencySortByQuickSort(s));
    }
}
