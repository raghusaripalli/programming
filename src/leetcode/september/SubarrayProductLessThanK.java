package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, left = 0, prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK sp = new SubarrayProductLessThanK();
        System.out.println(sp.numSubarrayProductLessThanK(Helper.parseIntegerArray("[10,5,2,6]"), 100));
    }
}
