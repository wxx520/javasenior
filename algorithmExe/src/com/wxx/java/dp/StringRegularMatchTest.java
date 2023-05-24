package com.wxx.java.dp;

import org.junit.Test;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class StringRegularMatchTest {

    /**
     * 状态定义：
     * 定义boolean类型 dp[m][n]为二维数组，其中dp[i][j],表示s的前i个字符和p的前j个字符是否能匹配
     * 转移方程：对于d[i][j]
     * 1.1 如果p[j-1] == '*'(p.charAt(j-1)==‘*’)，
     * 1.1.1 如果 p[j-2]==s[i-1](即p[j-2]p[j-1]为【s[j-1]字母*】组合)，且dp[i-1][j]==true，则dp[i][j]=true;
     * 1.1.2 如果 p[j-2]=='.'(即p[j-2]p[j-1]为【。*】组合)，且dp[i-1][j]==true，则dp[i][j]=true;
     * 1.1.3 如果 p[j-2]！=s[i-1]&&p[j-2]！='.'(即p[j-2]p[j-1]为【字母*】组合,且p[j-2]与字母s[i-1]不匹配),则如果d[i][j-2]为true，则dp[i][j]=true;
     * 1.2 如果p[j-1] != '*'，则
     * 1.2.1 如果 p[j-1]==s[i-1]或p[j-1]=='.'，且dp[i-1][j-1]==true，则dp[i][j]=true;
     * 1.2.2 否则均为false
     * <p>
     * 初始化：
     * d[0][0]=true，表示s、p长度均为0时正则匹配的结果为true
     * d[i][0]=false,0<i<=m，表示如果s为不为空，p为空, 则s和p的正则关系总是false
     * d[0][j]=d[0][j-2]&&p.charAt(j-1)==‘*’,j>=2,j=j+2,j<=n,即若n为基数，则不能每两个组成‘a-z*’或‘。*’组合，即为false
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchByDP(String s, String p) {
        if (s == null || p == null) {//若有一方为null则认为匹配失败
            return false;
        }

        if (s.length() > 0 && p.length() == 0) {//1.2 当s不为空，但是p为空时总是不匹配的
            return false;
        }

        int m = s.length() + 1, n = p.length() + 1;

        //s、p的匹配情况
        boolean[][] dp = new boolean[m][n];

        //初始化边界：1.1
        dp[0][0] = true;

        //1.2 dp[i][0]=false，使用数组的默认值false，其中0<i<=m;

        //1.3 其中dp[0][2j+1]=false，其中2j+1<n;
        for (int j = 2; j < n; j = j + 2) {
            dp[0][j] = dp[0][j - 2] && (p.charAt(j - 1) == '*');
        }

        //状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char pChar = p.charAt(j - 1);
                if (pChar == '*') {//1.1 如果p的第j个元素为*
                    if (dp[i][j - 2]) {//1.1.1
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) { //1.1.2
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 2) == '.') { //1.1.3
                        dp[i][j] = true;
                    }
                } else {//1.2 如果p的第j个元素不为*
                    dp[i][j] = (pChar == s.charAt(i - 1) || pChar == '.') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void t1() {
        String s1 = "abcd";
        String p1 = ".*";
        String p2 = "...";
        System.out.println("*a".startsWith("*"));
        System.out.println(s1.matches(p2));
        System.out.println(".*".equals(".*"));
        System.out.println(".*".equals(null));
        System.out.println(p1.contains("//*"));
        System.out.println("".matches(p1));
    }

    @Test
    public void name() {
        String s = "1";
        System.out.println("".matches("a*"));
        System.out.println(s.substring(1, s.length()));
        ;
    }
}
