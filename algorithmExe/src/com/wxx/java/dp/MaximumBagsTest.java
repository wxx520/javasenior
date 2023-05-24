package com.wxx.java.dp;

import java.util.Arrays;

public class MaximumBagsTest {

    /**
     * 备用空间数组
     * 然后从小打到排序
     * additionalRocks 从小到大补给，一直到补给用完
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int capacityLen = capacity.length;
        int[] margin = new int[capacityLen];
        int fullBagNum = 0;
        int marginSum = additionalRocks;
        for (int i = 0; i < capacityLen; i++) {
            margin[i] = capacity[i] - rocks[i];
            if (margin[i] == 0) {
                fullBagNum++;
            }
            marginSum -= margin[i];
        }
        if (additionalRocks == 0 || fullBagNum == capacityLen) {
            return fullBagNum;
        }
        if (marginSum >= 0) {
            return capacityLen;
        }

        Arrays.sort(margin);
        for (int m : margin) {
            if (additionalRocks < m) {
                break;
            }
            if (m > 0) {
                additionalRocks = additionalRocks - m;
                fullBagNum++;
            }
        }
        return fullBagNum;
    }

    public int maximumBags1(int[] capacity, int[] rocks, int additionalRocks) {
        int capacityLen = capacity.length;
        int[] margin = new int[capacityLen];
        int fullBagNum = 0;
        for (int i = 0; i < capacityLen; i++) {
            margin[i] = capacity[i] - rocks[i];
            if (margin[i] == 0) {
                fullBagNum++;
            }
            if (margin[i] == 1) {
                additionalRocks--;
                fullBagNum++;
            }
        }
        if (additionalRocks == 0 || fullBagNum == capacityLen) {
            return fullBagNum;
        }

        Arrays.sort(margin);
        for (int m : margin) {
            if (m > 0 && additionalRocks > 0) {
                additionalRocks = additionalRocks - m;
                if (additionalRocks < 0) {
                    break;
                }
                fullBagNum++;
                if (additionalRocks == 0) {
                    break;
                }
            }
        }
        return fullBagNum;
    }
}
