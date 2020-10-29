package leetcode.october;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    private void addString(int start, int end, List<String> res) {
        if (end <= start) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + end);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        int start = nums[0], end = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end = nums[i];
            } else {
                addString(start, end, res);
                start = nums[i];
            }
        }
        addString(start, end, res);
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(new int[0]));
        System.out.println(summaryRanges.summaryRanges(new int[]{0}));
        System.out.println(summaryRanges.summaryRanges(new int[]{-1}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 6, 7, 9}));
    }
}
