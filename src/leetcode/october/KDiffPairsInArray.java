package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;

public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int a = 0, b = 1, n = nums.length, diff;
        while (b < n) {
            diff = nums[b] - nums[a];
            if (diff == k) {
                count++;
            }
            if (diff <= k) {
                int num = nums[b];
                b++;
                while (b < n && nums[b] == num) {
                    b++;
                }
            } else {
                a++;
                if (a == b) {
                    b++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KDiffPairsInArray kd = new KDiffPairsInArray();
        System.out.println(kd.findPairs(Helper.parseIntegerArray("[3,1,4,1,5]"), 2));
    }
}
