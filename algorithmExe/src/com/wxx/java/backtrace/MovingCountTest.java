package com.wxx.java.backtrace;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lhbac
 * @create 2023/9/1 20:14
 * <p>
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
 */
public class MovingCountTest {


    /**
     * 广度优先遍历
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] directions = {{1, 0}, {0, 1}};
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        vis[0][0] = true;
        int ans = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] de : directions) {
                int tx = cell[0] + de[0];
                int ty = cell[1] + de[1];
                if (tx >= m || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.add(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;

    }

    public int movingCountByDFS(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];

        vis[0][0] = true;
        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }

                if (i - 1 >= 0) {
                    vis[i][j] = vis[i - 1][j];
                }

                if (j - 1 >= 0) {
                    vis[i][j] = vis[i][j - 1];
                }

                ans += vis[i][j] ? 1 : 0;
            }
        }

        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
