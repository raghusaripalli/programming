package leetcode;// Problem Statement: https://leetcode.com/problems/counting-bits/
// DP, Bit Manipulation

public class CountingBits {
    // Try Seeing the pattern between [2, 3], [4, 7], [8, 15] and [16, 31]. Each series depends on the before series answer pattern
    public int[] countBits(int num) {
        int[] res = new int[++num];
        int i = 0, startIdx = 2, endIdx = 4, j = 4;
        while (i < num && i <= 4) {
            if (i == 0) res[0] = 0;
            else if (i == 1) res[1] = 1;
            else if (i == 2) res[2] = 1;
            else if (i == 3) res[3] = 2;
            i++;
        }
        while (num > 4 && j < num) {
            i = startIdx;
            while (i < endIdx && j < num) {
                res[j++] = res[i++];
            }
            i = startIdx;
            while (i < endIdx && j < num) {
                res[j++] = res[i++] + 1;
            }
            startIdx *= 2;
            endIdx *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        // Test Case
        int[] res = countingBits.countBits(31);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
