package com.wxx.java.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lhbac
 * @create 2023/8/28 19:11
 */
public class SolveNQueensTest {

    public List<List<String>> solveNQueens1(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[][] used = new int[n][n];
        dfs(n, 0, new ArrayList<Integer>(), solutions, used);
        return solutions;
    }

    private void dfs(int n, int depth, ArrayList<Integer> path, List<List<String>> solutions, int[][] used) {
        if (depth == n) {
            solutions.add(generateBoard(path, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[depth][i] > 0) {
                continue;
            }
            path.add(i);
            fill(used, depth, i, 1);

            dfs(n, depth + 1, path, solutions, used);

            path.remove(path.size() - 1);
            fill(used, depth, i, -1);

        }

    }

    private void fill(int[][] used, int queenX, int queenY, int v) {
        int m = used.length;
        int n = used[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isInQueen(queenX, queenY, i, j)) {
                    used[i][j] = used[i][j] + v;
                }
            }
        }
    }

    private boolean isInQueen(int queenX, int queenY, int i, int j) {
        return (queenX == i) || (queenY == j) || (i + j == queenX + queenY || i - j == queenX - queenY);
    }

    public List<String> generateBoard(List<Integer> queens, int n) {
        List<String> board = new ArrayList<>();
        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int i = 0; i < n; i++) {
            row[queens.get(i)] = 'Q';
            board.add(new String(row));
            row[queens.get(i)] = '.';
        }
        return board;
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int i = 0; i < n; i++) {
            row[queens[i]] = 'Q';
            board.add(new String(row));
            row[queens[i]] = '.';
        }
        return board;
    }

    @Test
    public void t1() {
        System.out.println(solveNQueens(1));
        System.out.println(solveNQueens(2));
        System.out.println(solveNQueens(3));
        System.out.println(solveNQueens(4).size());
        System.out.println(solveNQueens(5).size());
    }
}
