package com.wxx.java.search;

/**
 * @author wxxstar
 * @create 2023-08-03 22:34
 */
public class SearchMatrixTest {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            }
            if (num < target) {
                x++;
            } else {
                y--;
            }
        }

        return false;

    }
}
