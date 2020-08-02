package leetcode.may_april_june_challenge;

public class SurrondedRegions {
    private char endChar = '-';

    private void conv(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'O') {
            board[i][j] = endChar;
            conv(board, i - 1, j);
            conv(board, i + 1, j);
            conv(board, i, j - 1);
            conv(board, i, j + 1);
        }
    }

    private void solve(char[][] board) {
        if (board.length == 0) return;
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (board[i][j] == 'O') {
                        conv(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == endChar) board[i][j] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        SurrondedRegions regions = new SurrondedRegions();
        // Test Case
        char[][] board = new char[4][4];
        board[0] = "XXXX".toCharArray();
        board[1] = "XOOX".toCharArray();
        board[2] = "OXXX".toCharArray();
        board[3] = "XOXX".toCharArray();
        regions.solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }
}