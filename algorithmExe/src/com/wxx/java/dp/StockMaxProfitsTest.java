package com.wxx.java.dp;

/**
 * @author wxxstar
 * @create 2023-04-21 0:30
 */

import org.junit.Test;

/**
 * 求股票的最大收益，给定一个数组{3, 5, 4, 2, 6, 8,1,2,1,11}，为每天的股票价格，卖出后才能买进，求能获取的最大收益
 */
public class StockMaxProfitsTest {

    public int maxProfitsByDP(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length <= 1) {
            return 0;
        }
        int[] profits = new int[stockPrices.length];
        for (int i = 1; i < stockPrices.length; i++) {
            profits[i] = profits[i - 1] + Math.max(0, stockPrices[i] - stockPrices[i - 1]);
        }
        return profits[stockPrices.length - 1];
    }

    /**
     * 仅能交易一次获取最大收益
     * @param stockPrices 连续几天的股票价格
     * @return
     */
    public int maxProfitsForSingleTrade(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length <= 1) {
            return 0;
        }
        int intervalMaxPrice = stockPrices[0];
        int intervalMinPrice = stockPrices[0];
        int maxProfit = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            int prePrice = stockPrices[i - 1];
            if (currentPrice == prePrice || (currentPrice < intervalMaxPrice && currentPrice >= intervalMinPrice)) {
                continue;
            }
            if (currentPrice > prePrice) {
                intervalMaxPrice = currentPrice;
                maxProfit = Math.max(maxProfit, intervalMaxPrice - intervalMinPrice);
                continue;
            }

            //currentPrice<prePrice,即出现更低的价格，则结清上一次的高收益
            maxProfit = Math.max(maxProfit, intervalMaxPrice - intervalMinPrice);
            intervalMinPrice = intervalMaxPrice = currentPrice;
        }
        return maxProfit;
    }

    /**
     * 过去影响未来虽大收益的是，过去出现的最低价，过去出现的区间最大收益
     *
     * @param stockPrices
     * @return
     */
    public int maxProfitsForSingleTrade1(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length <= 1) {
            return 0;
        }
        int intervalMinPrice = stockPrices[0];
        int maxProfit = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            maxProfit = Math.max(maxProfit,stockPrices[i]-intervalMinPrice);
            if(stockPrices[i]<intervalMinPrice){
                intervalMinPrice = stockPrices[i];
            }
        }
        return maxProfit;
    }

    public int maxProfitsForSingleTradeByDP(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length <= 1) {
            return 0;
        }
        int[] maxProfits = new int[2*stockPrices.length];
        maxProfits[0] = stockPrices[0];
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            int preMinPrice = maxProfits[2*i-2];
            maxProfits[2*i] = Math.min(preMinPrice,currentPrice);
            maxProfits[2*i+1] = Math.max(maxProfits[2*i-1],currentPrice-preMinPrice);
        }
        return maxProfits[maxProfits.length-1];
    }

    @Test
    public void t1() {
        System.out.println(maxProfitsByDP(null));
        System.out.println(maxProfitsByDP(new int[]{3}));
        System.out.println(maxProfitsByDP(new int[]{3, 1}));
        System.out.println(maxProfitsByDP(new int[]{3, 5, 4, 2, 6, 8, 1, 2, 1, 11}));
        System.out.println(maxProfitsForSingleTrade(new int[]{3, 5, 4, 7, 6, 21, 1, 2, 1, 11}));
        System.out.println(maxProfitsForSingleTradeByDP(new int[]{3, 5, 4, 7, 6, 21, 1, 2, 1, 11}));
    }
}
