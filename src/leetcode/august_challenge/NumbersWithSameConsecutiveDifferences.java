package leetcode.august_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }

        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);

        return results.stream().mapToInt(i -> i).toArray();
    }

    private void DFS(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();

        int tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                int newNum = num * 10 + nextDigit;
                this.DFS(N - 1, newNum, K, results);
            }
        }
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences numsObj = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(numsObj.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(numsObj.numsSameConsecDiff(2, 1)));
    }
}
