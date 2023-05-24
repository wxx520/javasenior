package com.wxx.java.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/99wd55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AZTranslateNumTest {
    /**
     * 1、获取num的位数长度
     * 2、假设d[i]为为num前i(i>1)位的翻译方法数，则
     * 有 d[i] = d[i-1]+(9<num[i-1]num[i]<26)?d[i-2]:0;
     * 其中d[0] = 1; d[1]=1;
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if(num<0||num>Integer.MAX_VALUE-1){//越界
            return 0;
        }
        if((num/10)==0){
            return 1;
        }

        String numStr = String.valueOf(num);
        int numLength = numStr.length();
        int[] dp = new int[numLength+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= numLength; i++) {
            int tempNum = Integer.valueOf(numStr.substring(i-2,i));
            dp[i] = dp[i-1]+(((tempNum<26&&tempNum>9))?dp[i-2]:0);
        }
        return dp[numLength];
    }

    public static void main(String[] args) {
        //System.out.println((2<<29-1)+2<<29);
        System.out.println(translateNum(12258));
        System.out.println("12258".substring(3,5));
    }
}
