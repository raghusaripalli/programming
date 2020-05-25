public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int aSize = A.length, bSize = B.length;
        int[][] dp = new int[aSize + 1][bSize + 1];
        for (int i = 1; i <= aSize; i++) {
            for (int j = 1; j <= bSize; j++) {
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[aSize][bSize];
    }

    public static void main(String[] args) {
        UncrossedLines lines = new UncrossedLines();
        // Test Case 1  - A = [1,4,2], B = [1,2,4]
        int[] A = new int[3];
        int[] B = new int[3];
        A[0] = 1;
        A[1] = 4;
        A[2] = 4;
        B[0] = 1;
        B[1] = 2;
        B[2] = 4;
        int res = lines.maxUncrossedLines(A, B);
        System.out.println(res);
    }
}
