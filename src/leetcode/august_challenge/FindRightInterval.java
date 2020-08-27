package leetcode.august_challenge;

import java.util.Arrays;
import java.util.TreeMap;

public class FindRightInterval {
    private int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if (n == 1)
            return new int[]{-1};

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            result[i] = key == null ? -1 : map.get(key);
        }

        return result;
    }

    public static void main(String[] args) {
        FindRightInterval fri = new FindRightInterval();
        int[][] interval = new int[1][2];
        interval[0][0] = 1;
        interval[0][1] = 2;
        System.out.println(Arrays.toString(fri.findRightInterval(interval)));
    }
}
