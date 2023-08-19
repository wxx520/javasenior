package com.wxx.java.datastructure;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-08-15 8:32
 */
public class StrToIntTest {
    public int strToInt(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }
        String s = str.trim();
        int len = 11;
        char[] arr = new char[len];
        return 2;
    }


    /**
     * 1、开头空格直接过滤
     *
     * @param str
     * @return
     */
    public int strToIntByBF(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }
        int len = 11;
        char[] arr = new char[len];
        arr[0] = '+';
        int i = 1;
        boolean isFlag = false;
        boolean isNotFirstZero = true;
        boolean isValid = false;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (isValid && (i == 1)) {
                    return 0;
                }
                if (i > 1) {
                    break;
                }
                continue;
            }
            if (c == '-' && i <= 1) {
                if (isFlag || isValid) {
                    return 0;
                }
                isValid = true;
                if (i > 1) {
                    break;
                }
                arr[0] = '-';
                isFlag = true;
                continue;

            }

            if (c == '+' && i <= 1) {
                if (isFlag || isValid) {
                    return 0;
                }
                isValid = true;
                if (i > 1) {
                    break;
                }
                isFlag = true;
                continue;
            }
            if (c == '0' && isNotFirstZero) {
                isValid = true;
                continue;
            }
            if (c - '0' < 0 || c - '9' > 0) {
                if (i == 1) {
                    return 0;
                }
                break;
            }
            isValid = true;
            isNotFirstZero = false;
            if (i >= len) {
                return arr[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            arr[i++] = c;
        }
        if (i <= 1) {
            return 0;
        }
        if (i < len) {
            int power = 10;
            int res = arr[i - 1] - '0';
            i--;
            while (i > 1) {
                res += (arr[i - 1] - '0') * power;
                power = power * 10;
                i--;
            }
            return arr[0] == '-' ? (0 - res) : res;
        } else if (arr[0] == '-') {
            int power = 1000000000;
            int base = 0 - (Integer.MIN_VALUE + 1);
            int highestDigit = arr[1] - '0';
            if (highestDigit > (base / power)) {
                return Integer.MIN_VALUE;
            }
            int index = 2;
            int res = 0;
            power = power / 10;
            while (index < i) {
                res += (arr[index] - '0') * power;
                power = power / 10;
                index++;
            }
            if (highestDigit == 1) {
                return 0 - (res + 1000000000);
            } else if ((base - 2 * 1000000000) <= res - 1) {
                return Integer.MIN_VALUE;
            }
            return 0 - (res + 2 * 1000000000);
        } else {
            int power = 1000000000;
            int base = Integer.MAX_VALUE;
            int highestDigit = arr[1] - '0';
            if (highestDigit > (base / power)) {
                return Integer.MAX_VALUE;
            }
            int index = 2;
            int res = 0;
            power = power / 10;
            while (index < i) {
                res += (arr[index] - '0') * power;
                power = power / 10;
                index++;
            }
            if (highestDigit == 1) {
                return res + 1000000000;
            } else if ((base - 2 * 1000000000) <= res) {
                return Integer.MAX_VALUE;
            }
            return res + 2 * 1000000000;
        }
    }

    @Test
    public void t1() {
        System.out.println(strToInt("0+1"));
        System.out.println(strToInt("-"));
        System.out.println(strToInt("+0012"));
        System.out.println(strToInt("-00 12"));
        System.out.println(strToInt("  0000000000012345678"));
        //System.out.println(strToInt("4193 with words"));
        //System.out.println(strToInt("words and 987"));
        //System.out.println(strToInt("   -42"));
        System.out.println(strToInt("-2147483653"));
        System.out.println(strToInt("-2147483649"));
        System.out.println(strToInt("2147483648"));
        System.out.println(strToInt("2147483657"));
    }
}
