package leetcode.august_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            if (fresh > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    int x = cur / n;
                    int y = cur % n;
                    for (int[] dir : dirs) {
                        int nextX = x + dir[0];
                        int nextY = y + dir[1];
                        if (hasFreshOrange(grid, nextX, nextY)) {
                            queue.offer(nextX * n + nextY);
                            fresh--;
                        }
                    }
                }
                time++;
            }
            if (fresh == 0) {
                break;
            }
        }
        return fresh == 0 ? time : -1;
    }

    private boolean hasFreshOrange(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 2;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = new int[3][3];
        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[2][1] = 1;
        grid[2][2] = 1;
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
