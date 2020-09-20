package leetcode.september;

public class UniquePathsIII {
    private int path_count = 0;
    private int[][] grid;

    private void backtrack(int row, int col, int remain) {
        if (grid[row][col] == 2 && remain == 1) {
            this.path_count += 1;
            return;
        }
        int cell = grid[row][col];
        grid[row][col] = -4;
        remain -= 1;

        int[] row_offsets = {0, 0, 1, -1};
        int[] col_offsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i) {
            int next_row = row + row_offsets[i];
            int next_col = col + col_offsets[i];

            if (0 > next_row || next_row >= this.grid.length || 0 > next_col || next_col >= this.grid[0].length)
                continue;

            if (grid[next_row][next_col] < 0)
                continue;

            backtrack(next_row, next_col, remain);
        }

        grid[row][col] = cell;
    }

    public int uniquePathsIII(int[][] grid) {
        int empty_squares = 0, start_row = 0, start_col = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int cell = grid[row][col];
                if (cell >= 0)
                    empty_squares += 1;

                if (cell == 1) {
                    start_row = row;
                    start_col = col;
                }
            }
        }

        this.grid = grid;
        this.path_count = 0;
        backtrack(start_row, start_col, empty_squares);
        return this.path_count;
    }

    public static void main(String[] args) {
        UniquePathsIII up3 = new UniquePathsIII();
        System.out.println(up3.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(up3.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(up3.uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }
}
