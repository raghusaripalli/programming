package leetcode.august_challenge;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[intervals.length - 1][0];
        int count = 1;
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (end >= intervals[i][1]) {
                end = intervals[i][0];
                count++;
            }
        }
        return intervals.length - count;
    }

    static class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public static void main(String[] args) {
        NonOverlappingIntervals noi = new NonOverlappingIntervals();
        int[][] inputArr = new int[4][2];
        inputArr[0][0] = 1;
        inputArr[0][1] = 2;
        inputArr[1][0] = 2;
        inputArr[1][1] = 3;
        inputArr[2][0] = 3;
        inputArr[2][1] = 4;
        inputArr[3][0] = 1;
        inputArr[3][1] = 3;
        System.out.println(noi.eraseOverlapIntervals(inputArr));
    }
}
