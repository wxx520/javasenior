package com.wxx.java.math;

/**
 * @author wxxstar
 * @create 2023-08-11 21:01
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int max = 9;
        int i = 1;
        int digit = 1;
        while (n >= max) {
            n = n - max;
            digit = digit * 10;
            max = 9 * digit * (++i);
        }
        //剩下的n就是知道是多少进制的，哪一位数了
        int rank = n / i + (n % i != 0 ? 1 : 0);
        int number = digit + rank-1;
        int numberIndex = (n-1)%i;
        return Integer.valueOf(String.valueOf(number).substring(numberIndex,numberIndex+1));
    }

    public static void main(String[] args) {
        FindNthDigit test = new FindNthDigit();
        System.out.println("19".substring(1,2));
        System.out.println(test.findNthDigit(1000000000));
    }
}
