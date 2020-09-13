package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;

        // add all the intervals to the left of overlapping interval
        while (i < intervals.length && intervals[i][1] < newStart) {
            res.add(intervals[i++]);
        }

        // Combine all the intervals overlapping as one
        while (i < intervals.length && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        res.add(new int[]{newStart, newEnd});

        // add the rest of non-overlapping intervals
        while (i < intervals.length) res.add(intervals[i++]);

        int[][] ans = new int[res.size()][];
        for (int i1 = 0; i1 < res.size(); i1++) {
            ans[i1] = res.get(i1);
        }
        return ans;
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = new int[2][];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{6, 9};
        int[] newInterval = new int[]{2, 5};
        int[][] res = ii.insert(intervals, newInterval);
        for (int[] re : res) {
            Helper.prettyPrint(re);
        }
    }
}
