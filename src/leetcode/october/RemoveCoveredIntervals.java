package leetcode.october;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null)
                for (int j = 0; j < intervals.length; j++) {
                    if (i != j && intervals[j] != null) {
                        if (intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]) {
                            intervals[i] = null;
                            break;
                        }
                    }
                }
        }
        for (int[] interval : intervals) {
            if (interval != null) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals rc = new RemoveCoveredIntervals();
        int[][] ip = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(rc.removeCoveredIntervals(ip));
    }
}
