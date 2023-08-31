package com.wxx.java.backtrace;

/**
 * @author lhbac
 * @create 2023/8/29 17:32
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class WordExistInCharBoardTest {

    /**
     * 定义函数f(board，i,j, word, k, used[][]),
     * 表示从board[i][j]开始搜索word[k,word.len-1]能否成功，其中used[][]表示board已经被占用的格子
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean res = dfs(board, i, j, word, 0);
                if (res) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int depth) {
        if (board[i][j] != word.charAt(depth)) {
            return false;
        }
        if (depth == word.length() - 1) {
            return true;
        }
        char cTemp = board[i][j];
        board[i][j] = ' ';

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int n = board.length;
        int m = board[0].length;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newI > n - 1 || newJ < 0 || newJ > m - 1) {
                continue;
            }
            boolean res = dfs(board, newI, newJ, word, depth + 1);
            if (res) {
                return true;
            }
        }
        board[i][j] = cTemp;

        return false;

    }

}
